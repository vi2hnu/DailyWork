package org.example.flightinventoryfiles.repository;

import org.example.flightinventoryfiles.model.City;
import org.example.flightinventoryfiles.model.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    List<Schedule> findByFlight_IdAndDepartureDate(Long flightId, LocalDate date);
    List<Schedule> findByDepartureDateAndFromCityAndToCity(LocalDate departureDate, City fromCity, City toCity);
    Schedule findScheduleById(Long id);
}
