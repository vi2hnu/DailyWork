package org.example.airline.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.airline.model.entity.Schedule;
import org.example.airline.service.AirLineInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {
    private final AirLineInterface airLineInterface;

    public AirlineController(AirLineInterface airLineInterface) {
        this.airLineInterface = airLineInterface;
    }

    @PostMapping("/inventory/add")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        log.info("adding schedule");
        return airLineInterface.addSchedule(schedule);
    }

}
