package org.example.ticketbooking.controller;

import org.example.ticketbooking.model.entity.Ticket;
import org.example.ticketbooking.service.TicketDetailsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight/ticket/")
public class TicketController {

    private final TicketDetailsInterface ticketDetailsInterface;

    @Autowired
    public TicketController(TicketDetailsInterface ticketDetailsInterface) {
        this.ticketDetailsInterface = ticketDetailsInterface;
    }

    @GetMapping("/{pnr}")
    public Ticket findTicketByPnr(@PathVariable String pnr) {
        return ticketDetailsInterface.findTicketByPnr(pnr);
    }


}
