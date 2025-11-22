package org.example.webflux.repository;


import org.example.webflux.model.Tutorial;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TutorialRepository extends ReactiveCrudRepository<Tutorial, Integer> {
    Flux<Tutorial> findByPublished(boolean published);
}
