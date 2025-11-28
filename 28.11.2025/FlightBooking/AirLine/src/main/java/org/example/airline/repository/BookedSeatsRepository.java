package org.example.airline.repository;

import org.example.airline.model.entity.BookedSeats;
import org.springframework.data.repository.CrudRepository;


public interface BookedSeatsRepository extends CrudRepository<BookedSeats, Long> {
    boolean existsBySchedule_IdAndSeatPos(Long scheduleId, String seatPos);
    void deleteBySchedule_IdAndSeatPos(Long scheduleId, String seatPos);
}
