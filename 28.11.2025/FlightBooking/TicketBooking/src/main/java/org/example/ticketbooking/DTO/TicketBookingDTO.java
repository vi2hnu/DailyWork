package org.example.ticketbooking.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.ticketbooking.model.entity.Users;

import java.util.List;

public record TicketBookingDTO(
        @NotNull(message = "User cannot be null")
        Users user,

        @NotNull
        Long scheduleId,

        Long returnTripId,

        @NotEmpty(message = "Passengers list cannot be empty")
        List<PassengerDTO>passengers) {

}
