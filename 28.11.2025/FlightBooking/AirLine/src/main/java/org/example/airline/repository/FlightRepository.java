package org.example.airline.repository;

import org.example.airline.model.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight findFlightById(Long id);
}
