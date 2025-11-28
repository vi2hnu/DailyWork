package org.example.airline.repository;

import org.example.airline.model.entity.AirLine;
import org.springframework.data.repository.CrudRepository;

public interface AirLineRepository extends CrudRepository<AirLine, Long> {

}
