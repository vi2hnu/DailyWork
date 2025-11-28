package org.example.airline.service.implementation;

import org.example.airline.exception.CityNotFoundException;
import org.example.airline.exception.FlightNotFoundException;
import org.example.airline.exception.InvalidScheduleTimeException;
import org.example.airline.exception.ScheduleConflictException;
import org.example.airline.model.entity.City;
import org.example.airline.model.entity.Flight;
import org.example.airline.model.entity.Schedule;
import org.example.airline.repository.CityRepository;
import org.example.airline.repository.FlightRepository;
import org.example.airline.repository.ScheduleRepository;
import org.example.airline.service.AirLineInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AirLineService implements AirLineInterface {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {

        Flight flight = flightRepository.findFlightById(schedule.getFlight().getId());
        //check if flight exits
        if(flight == null){
            throw new FlightNotFoundException("Conflict: schedule overlaps with existing flight timings.");
        }
        schedule.setFlight(flight);
        //check if the time is valid
        if(schedule.getDepartureTime().isBefore(LocalDateTime.now())){
            throw new InvalidScheduleTimeException("Invalid schedule: departure time cannot be in the past.");
        }

        //check if city is valid
        City fromCity = cityRepository.findCitiesById(schedule.getFromCity().getId());
        City toCity = cityRepository.findCitiesById(schedule.getToCity().getId());
        if(fromCity == null || toCity == null){
            throw new CityNotFoundException("Invalid city");
        }
        schedule.setFromCity(fromCity);
        schedule.setToCity(toCity);

        List<Schedule> previousSchedule =
                scheduleRepository.findByFlight_IdAndDepartureDate(
                        schedule.getFlight().getId(),
                        schedule.getDepartureDate()
                );


        LocalDateTime newStart = schedule.getDepartureTime();
        LocalDateTime newEnd = newStart.plusMinutes(schedule.getDuration());
        boolean conflict = previousSchedule.stream()
                .anyMatch(s -> {
                    LocalDateTime existingStart = s.getDepartureTime();
                    LocalDateTime existingEnd   = existingStart.plusMinutes(s.getDuration());
                    return newStart.isBefore(existingEnd) && existingStart.isBefore(newEnd);
                });

        //check if there is a conflict
        if(conflict){
            throw new ScheduleConflictException("Conflict: schedule overlaps with existing flight timings.");
        }


        return scheduleRepository.save(schedule);
    }

}
