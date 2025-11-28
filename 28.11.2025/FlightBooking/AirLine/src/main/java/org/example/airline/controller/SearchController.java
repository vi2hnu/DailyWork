package org.example.airline.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.airline.DTO.SearchQueryDTO;
import org.example.airline.model.entity.Schedule;
import org.example.airline.service.SearchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/flight/search")
public class SearchController {

    private final SearchInterface searchInterface;
    @Autowired
    public SearchController(SearchInterface searchInterface) {
        this.searchInterface = searchInterface;
    }

    @PostMapping()
    public List<Schedule> search(@Valid @RequestBody SearchQueryDTO searchQueryDTO) {
        log.info("Searching for flights");
        return searchInterface.search(searchQueryDTO);
    }
}
