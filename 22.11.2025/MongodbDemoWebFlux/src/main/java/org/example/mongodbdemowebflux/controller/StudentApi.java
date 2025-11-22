package org.example.mongodbdemowebflux.controller;

import org.example.mongodbdemowebflux.model.Student;
import org.example.mongodbdemowebflux.service.StudentApiInterface;
import org.example.mongodbdemowebflux.service.implementation.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApi {

    private final StudentApiInterface studentService;

    public StudentApi(StudentApiInterface studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public Flux<Student> getAllStudents() {
        return studentService.getAllUrls();
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudentById(@PathVariable String id) {
        return studentService.getUrlById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id) {
        studentService.deleteUrlById(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @PostMapping("")
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
