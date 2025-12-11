package org.example.flightinventoryfiles.service;

import lombok.extern.slf4j.Slf4j;
import org.example.flightinventoryfiles.dto.ScheduleDTO;
import org.example.flightinventoryfiles.exception.CityNotFoundException;
import org.example.flightinventoryfiles.exception.FlightNotFoundException;
import org.example.flightinventoryfiles.exception.InvalidScheduleTimeException;
import org.example.flightinventoryfiles.exception.ScheduleConflictException;
import org.example.flightinventoryfiles.model.City;
import org.example.flightinventoryfiles.model.Flight;
import org.example.flightinventoryfiles.model.Schedule;
import org.example.flightinventoryfiles.repository.CityRepository;
import org.example.flightinventoryfiles.repository.FlightRepository;
import org.example.flightinventoryfiles.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AirLineService {

    private final ScheduleRepository scheduleRepository;
    private final FlightRepository flightRepository;
    private final CityRepository cityRepository;

    public AirLineService(ScheduleRepository scheduleRepository, FlightRepository flightRepository,
                          CityRepository cityRepository) {
        this.scheduleRepository = scheduleRepository;
        this.flightRepository = flightRepository;
        this.cityRepository = cityRepository;
    }

    private final Path root = Paths.get("uploads");

    public List<Schedule> parseFile(MultipartFile file) {
        try {
            Path filePath = this.root.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            ObjectMapper mapper = new ObjectMapper();

            List<ScheduleDTO> dtoList = mapper.readValue(
                    Files.newInputStream(filePath),
                    new TypeReference<List<ScheduleDTO>>() {}
            );

            return dtoList.stream()
                    .map(this::addSchedule)
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public Schedule addSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();

        Flight flight = flightRepository.findFlightById(scheduleDTO.flightId());
        //check if flight exits
        if(flight == null){
            log.error("flight not found: {}", scheduleDTO.flightId());
            throw new FlightNotFoundException("Flight not found");
        }

        int seats = flight.getColumns()*flight.getRows();
        schedule.setSeatsAvailable(seats);
        schedule.setFlight(flight);
        //check if the time is valid
        if(scheduleDTO.departureTime().isBefore(LocalDateTime.now())){
            throw new InvalidScheduleTimeException("Invalid schedule: departure time cannot be in the past.");
        }

        //check if city is valid
        City fromCity = cityRepository.findCitiesById(scheduleDTO.fromCityId());
        City toCity = cityRepository.findCitiesById(scheduleDTO.toCityId());
        if(fromCity == null || toCity == null){
            log.error("Invalid city in schedule");
            throw new CityNotFoundException("Invalid city");
        }

        schedule.setFromCity(fromCity);
        schedule.setToCity(toCity);

        List<Schedule> previousSchedule =
                scheduleRepository.findByFlight_IdAndDepartureDate(
                        schedule.getFlight().getId(),
                        scheduleDTO.departureDate()
                );

        //check if there is a conflict
        LocalDateTime newStart = scheduleDTO.departureTime();
        LocalDateTime newEnd = newStart.plusMinutes(scheduleDTO.duration());
        boolean conflict = previousSchedule.stream()
                .anyMatch(s -> {
                    LocalDateTime existingStart = s.getDepartureTime();
                    LocalDateTime existingEnd   = existingStart.plusMinutes(s.getDuration());
                    return newStart.isBefore(existingEnd) && existingStart.isBefore(newEnd);
                });

        if(conflict){
            log.error("Schedule already exists");
            throw new ScheduleConflictException("Conflict: schedule overlaps with existing flight timings.");
        }

        schedule.setDepartureTime(scheduleDTO.departureTime());
        schedule.setDuration(scheduleDTO.duration());
        schedule.setDepartureDate(scheduleDTO.departureDate());
        schedule.setPrice(scheduleDTO.price());

        return scheduleRepository.save(schedule);
    }

}
