package org.example.ticketbooking.service;

import org.example.ticketbooking.DTO.TicketBookingDTO;
import org.example.ticketbooking.model.entity.Ticket;

public interface TicketBookingInterface {
    public Ticket getTicket(TicketBookingDTO ticketBookingDTO);
}
