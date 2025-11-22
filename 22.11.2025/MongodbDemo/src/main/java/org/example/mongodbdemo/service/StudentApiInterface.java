package org.example.mongodbdemo.service;

import org.example.mongodbdemo.model.Student;

import java.util.List;

public interface StudentApiInterface {
    Student getUrlById(String id);
    List<Student> getAllUrls();
    void deleteUrlById(String id);
    Student updateStudent(String id, Student student);
    Student createStudent(Student student);
}
