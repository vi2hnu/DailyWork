package org.example.airline.service.implementation;

import org.example.airline.DTO.ScheduleDTO;
import org.example.airline.DTO.SeatsDTO;
import org.example.airline.model.entity.BookedSeats;
import org.example.airline.model.entity.Schedule;
import org.example.airline.repository.BookedSeatsRepository;
import org.example.airline.repository.ScheduleRepository;
import org.example.airline.service.ScheduleInterface;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService implements ScheduleInterface {

    private final ScheduleRepository scheduleRepository;
    private final BookedSeatsRepository bookedSeatsRepository;

    public ScheduleService(ScheduleRepository scheduleRepository,BookedSeatsRepository bookedSeatsRepository) {
        this.scheduleRepository = scheduleRepository;
        this.bookedSeatsRepository = bookedSeatsRepository;
    }

    @Override
    public ScheduleDTO getSchedule(Long scheduleId) {
       Schedule Schedule = scheduleRepository.findScheduleById(scheduleId);
       return new ScheduleDTO(Schedule);
    }

    @Override
    public boolean checkSeats(Long scheduleId, SeatsDTO seatsDTO) {
        return seatsDTO.seats().stream()
                .anyMatch(x->
                        bookedSeatsRepository.existsBySchedule_IdAndSeatPos(scheduleId,x)
                );
    }

    @Override
    public boolean reserveSeats(Long scheduleId, SeatsDTO seatsDTO) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId);
        seatsDTO.seats().stream()
                .forEach(seat ->bookedSeatsRepository.save(new BookedSeats(schedule,seat)));
        return true;
    }
}
