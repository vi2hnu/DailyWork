package org.example.mongodbdemo.controller;

import org.example.mongodbdemo.model.Student;
import org.example.mongodbdemo.service.StudentApiInterface;
import org.example.mongodbdemo.service.implementation.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApi {

    private final StudentApiInterface studentService;

    public StudentApi(StudentApiInterface studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllUrls();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getUrlById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id) {
        studentService.deleteUrlById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
