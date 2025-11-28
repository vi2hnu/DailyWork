package org.example.ticketbooking.DTO;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record SeatsDTO(List<String> Seats) {}
