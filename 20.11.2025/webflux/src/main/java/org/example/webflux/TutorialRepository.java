package org.example.webflux;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TutorialRepository extends ReactiveCrudRepository<Tutorial, Integer> {
    Flux<Tutorial> findByPublished(boolean published);
}
