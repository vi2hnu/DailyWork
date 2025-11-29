package org.example.ticketbooking.feign;

import org.example.ticketbooking.DTO.ScheduleDTO;
import org.example.ticketbooking.DTO.SeatsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "AirLine")
public interface AirLineClient {
    @GetMapping("/api/schedules/{id}")
    ScheduleDTO getSchedule(@PathVariable Long id);

    @PostMapping("/api/check/seats/{id}")
    boolean checkSeats(@PathVariable("id") Long id, @RequestBody SeatsDTO seatsDTO);

    @PostMapping("/api/reserve/seats/{id}")
    boolean reserveSeats(@PathVariable("id") Long id, @RequestBody SeatsDTO seatsDTO);

    @DeleteMapping("/api/delete/seats/{id}")
    void deleteSeats(@PathVariable("id") Long id,@RequestBody SeatsDTO seatsDTO);

    @PostMapping("/api/add/seats/{id}")
    void addSeats(@PathVariable Long id, @RequestBody int seats);
}
