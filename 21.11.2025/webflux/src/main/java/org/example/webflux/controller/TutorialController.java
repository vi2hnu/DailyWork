package org.example.webflux;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    private final TutorialService service;

    public TutorialController(TutorialService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Tutorial> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Tutorial> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Tutorial> create(@RequestBody Tutorial tutorial) {
        return service.create(tutorial);
    }

    @PutMapping("/{id}")
    public Mono<Tutorial> update(@PathVariable Integer id, @RequestBody Tutorial tutorial) {
        return service.update(id, tutorial);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/published")
    public Flux<Tutorial> published() {
        return service.getPublished();
    }
}
