package org.example.webflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialService {

    private final TutorialRepository repo;

    public TutorialService(TutorialRepository repo) {
        this.repo = repo;
    }

    public Flux<Tutorial> getAll() {
        return repo.findAll();
    }

    public Mono<Tutorial> getById(Integer id) {
        return repo.findById(id);
    }

    public Mono<Tutorial> create(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    public Mono<Tutorial> update(Integer id, Tutorial tutorial) {
        return repo.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(tutorial.getTitle());
                    existing.setDescription(tutorial.getDescription());
                    existing.setPublished(tutorial.isPublished());
                    return repo.save(existing);
                });
    }

    public Mono<Void> delete(Integer id) {
        return repo.deleteById(id);
    }

    public Flux<Tutorial> getPublished() {
        return repo.findByPublished(true);
    }
}
