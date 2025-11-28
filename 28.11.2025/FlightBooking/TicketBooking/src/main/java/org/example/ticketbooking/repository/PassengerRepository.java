package org.example.ticketbooking.repository;

import org.example.ticketbooking.model.entity.Passenger;
import org.springframework.data.repository.CrudRepository;

public  interface PassengerRepository  extends CrudRepository<Passenger, Long> {
}
