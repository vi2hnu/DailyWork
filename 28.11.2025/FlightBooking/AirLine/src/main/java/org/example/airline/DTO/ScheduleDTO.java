package org.example.airline.DTO;


import org.example.airline.model.entity.Schedule;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ScheduleDTO(
        Long id,
        Long flightId,
        Long fromCityId,
        Long toCityId,
        LocalDate departureDate,
        LocalDateTime departureTime,
        float price,
        int seatsAvailable,
        int duration
) {
    public ScheduleDTO(Schedule s) {
        this(
                s.getId(),
                s.getFlight() != null ? s.getFlight().getId() : null,
                s.getFromCity() != null ? s.getFromCity().getId() : null,
                s.getToCity() != null ? s.getToCity().getId() : null,
                s.getDepartureDate(),
                s.getDepartureTime(),
                s.getPrice(),
                s.getSeatsAvailable(),
                s.getDuration()
        );
    }
}
