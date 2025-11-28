package org.example.ticketbooking.repository;

import org.example.ticketbooking.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findTicketByPnr(String pnr);
    List<Ticket> findAllByBookedByUsers_Id(Long id);
}
