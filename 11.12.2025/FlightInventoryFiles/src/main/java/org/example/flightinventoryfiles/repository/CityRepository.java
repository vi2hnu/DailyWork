package org.example.flightinventoryfiles.repository;

import org.example.flightinventoryfiles.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    City findCityByAirportCode(String airportCode);
    City findCitiesById(Long id);
}
