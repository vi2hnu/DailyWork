package org.example.flightinventoryfiles.repository;

import org.example.flightinventoryfiles.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight findFlightById(Long id);
}
