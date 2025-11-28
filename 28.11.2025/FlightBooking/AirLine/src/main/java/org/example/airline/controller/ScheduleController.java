package org.example.airline.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.airline.DTO.ScheduleDTO;
import org.example.airline.DTO.SeatsDTO;
import org.example.airline.model.entity.Schedule;
import org.example.airline.service.ScheduleInterface;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleInterface scheduleService;

    public ScheduleController(ScheduleInterface scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules/{id}")
    public ScheduleDTO getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    @PostMapping("/check/seats/{id}")
    public boolean checkSeats(@PathVariable Long id, @RequestBody SeatsDTO seatsDTO) {
        log.info("seats at controller {}", seatsDTO);
        return scheduleService.checkSeats(id, seatsDTO);
    }

    @PostMapping("/reserve/seats/{id}")
    public boolean reserveSeats(@PathVariable Long id, @RequestBody SeatsDTO seatsDTO) {
        return scheduleService.reserveSeats(id, seatsDTO);
    }


    @DeleteMapping("/api/delete/seats/{id}")
    void deleteSeats(@PathVariable("id") Long id, @RequestBody SeatsDTO seatsDTO) {

    }
}
