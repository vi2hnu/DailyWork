package org.example.mongodbdemowebflux.service;

import org.example.mongodbdemowebflux.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentApiInterface {
    Mono<Student> getUrlById(String id);
    Flux<Student> getAllUrls();
    void deleteUrlById(String id);
    Mono<Student> updateStudent(String id, Student student);
    Mono<Student> createStudent(Student student);
    Mono<Student> addStudent(Student student);
}
