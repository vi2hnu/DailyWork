package org.example.airline.DTO;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record SearchQueryDTO(
        @NotBlank
        String fromCity,

        @NotBlank
        String toCity,

        LocalDate date) {
}
