package org.example.airline.service;

import org.example.airline.DTO.ScheduleDTO;
import org.example.airline.DTO.SeatsDTO;
import org.example.airline.model.entity.Schedule;

public interface ScheduleInterface {
    ScheduleDTO getSchedule(Long scheduleId);
    boolean checkSeats(Long scheduleId, SeatsDTO seatsDTO);
    boolean reserveSeats(Long scheduleId, SeatsDTO seatsDTO);
    void deleteSeats(Long scheduleId, SeatsDTO seatsDTO);
    void addSeats(Long scheduleId, int seats);
}
