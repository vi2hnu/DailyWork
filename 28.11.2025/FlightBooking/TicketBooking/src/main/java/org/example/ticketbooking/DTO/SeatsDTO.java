package org.example.ticketbooking.DTO;

import java.util.List;

public record SeatsDTO(List<String> seats) {
    public SeatsDTO(List<String> seats) {
        this.seats = seats;
    }
}
