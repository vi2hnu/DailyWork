package org.example.ticketbooking.DTO;

import jakarta.validation.constraints.NotBlank;
import org.example.ticketbooking.model.enums.Gender;
import org.example.ticketbooking.model.enums.Meal;

public record PassengerDTO(
        @NotBlank
        String name,

        @NotBlank
        Gender gender,

        @NotBlank
        Meal meal,

        @NotBlank
        String seatPos) {
}
