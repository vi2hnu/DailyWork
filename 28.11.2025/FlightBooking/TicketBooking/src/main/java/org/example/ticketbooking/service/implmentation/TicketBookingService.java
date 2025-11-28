package org.example.ticketbooking.service.implmentation;

import lombok.extern.slf4j.Slf4j;
import org.example.ticketbooking.DTO.ScheduleDTO;
import org.example.ticketbooking.DTO.SeatsDTO;
import org.example.ticketbooking.DTO.TicketBookingDTO;
import org.example.ticketbooking.exception.InvalidScheduleTimeException;
import org.example.ticketbooking.exception.SeatNotAvailableException;
import org.example.ticketbooking.feign.AirLineClient;
import org.example.ticketbooking.model.entity.*;
import org.example.ticketbooking.model.enums.Status;
import org.example.ticketbooking.repository.TicketRepository;
import org.example.ticketbooking.service.TicketBookingInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TicketBookingService implements TicketBookingInterface {

    private final TicketRepository ticketRepository;
    private final AirLineClient airLineClient;

    public TicketBookingService(TicketRepository ticketRepository, AirLineClient airLineClient) {
        this.ticketRepository = ticketRepository;
        this.airLineClient = airLineClient;
    }

    @Override
    public Ticket getTicket(TicketBookingDTO dto) {

        ScheduleDTO outbound = airLineClient.getSchedule(dto.scheduleId());
        if (outbound == null) {
            throw new InvalidScheduleTimeException("Invalid schedule");
        }

        ScheduleDTO returnTrip = null;
        if (dto.returnTripId() != null) {
            returnTrip = airLineClient.getSchedule(dto.returnTripId());
        }

        SeatsDTO seatsDTO = new SeatsDTO(
                dto.passengers().stream().map(p -> p.seatPos()).toList()
        );

        boolean seatConflict = airLineClient.checkSeats(outbound.id(), seatsDTO);
        if (seatConflict) {
            throw new SeatNotAvailableException("Seat already booked");
        }

        if (outbound.seatsAvailable() < dto.passengers().size()) {
            throw new SeatNotAvailableException("Not enough seats available");
        }

        airLineClient.reserveSeats(outbound.id(), seatsDTO);

        Ticket saved = createTicket(dto, outbound, returnTrip);

        savePassengers(saved, dto);

        return saved;
    }

    private Ticket createTicket(TicketBookingDTO dto, ScheduleDTO outbound, ScheduleDTO returnTrip) {

        Ticket ticket = new Ticket();
        String pnr = "PNR" + System.currentTimeMillis() + dto.user().getId();

        ticket.setPnr(pnr);
        ticket.setBookedByUsers(dto.user());

        ticket.setScheduleId(outbound.id());

        if (returnTrip != null) {
            ticket.setReturnTripScheduleId(returnTrip.id());
        }

        ticket.setStatus(Status.BOOKED);

        return ticketRepository.save(ticket);
    }

    private void savePassengers(Ticket ticket, TicketBookingDTO dto) {
        List<Passenger> passengers = new ArrayList<>();

        dto.passengers().forEach(p -> {
            Passenger entity = new Passenger();
            entity.setName(p.name());
            entity.setGender(p.gender());
            entity.setMealOption(p.meal());
            entity.setSeatPosition(p.seatPos());
            entity.setTicket(ticket);
            passengers.add(entity);
        });

        ticket.setPassengers(passengers);
        ticketRepository.save(ticket);
    }
}
