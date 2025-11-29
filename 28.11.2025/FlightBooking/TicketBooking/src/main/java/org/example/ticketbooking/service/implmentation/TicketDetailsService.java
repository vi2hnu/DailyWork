package org.example.ticketbooking.service.implmentation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import org.example.ticketbooking.DTO.ScheduleDTO;
import org.example.ticketbooking.DTO.SeatsDTO;
import org.example.ticketbooking.exception.InvalidScheduleTimeException;
import org.example.ticketbooking.exception.TicketNotFoundException;
import org.example.ticketbooking.exception.UsersNotFoundException;
import org.example.ticketbooking.feign.AirLineClient;
import org.example.ticketbooking.model.entity.Ticket;
import org.example.ticketbooking.model.entity.Users;
import org.example.ticketbooking.model.enums.Status;
import org.example.ticketbooking.repository.*;
import org.example.ticketbooking.service.TicketDetailsInterface;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailsService implements TicketDetailsInterface {

    private final TicketRepository ticketRepository;
    private final UsersRepository usersRepository;
    private final PassengerRepository passengerRepository;
    private final AirLineClient  airLineClient;

    public TicketDetailsService(TicketRepository ticketRepository,UsersRepository usersRepository,
                                PassengerRepository passengerRepository,AirLineClient airLineClient) {
        this.ticketRepository = ticketRepository;
        this.usersRepository = usersRepository;
        this.passengerRepository = passengerRepository;
        this.airLineClient = airLineClient;
    }

    @Override
    public Ticket findTicketByPnr(String pnr) {
        Ticket ticket = ticketRepository.findTicketByPnr(pnr);
        //check if ticket is valid
        if(ticket == null){
            throw new TicketNotFoundException("Invalid pnr number");
        }
        return ticket;
    }

    @Override
    public List<Ticket> findHistoryByEmail(String email) {
        Users user = usersRepository.findByEmail(email);
        if(user==null){
            throw new UsersNotFoundException("User Not Found");
        }
        return ticketRepository.findAllByBookedByUsers_Id(user.getId());
    }

    @Override
    @Transactional
    public Ticket cancelTicket(String pnr) {
        Ticket ticket = ticketRepository.findTicketByPnr(pnr);
        LocalDateTime currentTime = LocalDateTime.now();
        ScheduleDTO schedule = airLineClient.getSchedule(ticket.getScheduleId());

        Duration diff = Duration.between(currentTime, schedule.departureTime()).abs();

        if (diff.toHours() < 24) {
            throw new InvalidScheduleTimeException("Less than 24 hours gap");
        }

        //check if ticket is valid
        if(ticket==null){
            throw new TicketNotFoundException("Invalid pnr number");
        }
        //check if the ticket is already canceled
        if(ticket.getStatus()==Status.CANCELED){
            return ticket;
        }
        ticket.setStatus(Status.CANCELED);
        ticketRepository.save(ticket);
//        schedule.setSeatsAvailable(schedule.getSeatsAvailable() + ticket.getPassengers().size());
        airLineClient.addSeats(ticket.getScheduleId(),ticket.getPassengers().size());
        List<String> seats = new ArrayList<>();
        ticket.getPassengers().forEach(passenger -> {
//            if (passenger.getSeatPosition() != null) {
//                bookedSeatsRepository.deleteBySchedule_IdAndSeatPos(schedule.getId(), passenger.getSeatPosition());
//            }
            seats.add(passenger.getSeatPosition());
            passengerRepository.delete(passenger);
        });
        airLineClient.deleteSeats(ticket.getScheduleId(),new SeatsDTO(seats));
        return ticket;
    }
}
