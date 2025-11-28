package org.example.airline.service;

import org.example.airline.DTO.SearchQueryDTO;
import org.example.airline.model.entity.Schedule;

import java.util.List;

public interface SearchInterface {
    List<Schedule> search(SearchQueryDTO searchQueryDTO);
}
