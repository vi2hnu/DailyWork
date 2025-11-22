package org.example.mongodbdemo.service.implementation;

import org.example.mongodbdemo.model.Student;
import org.example.mongodbdemo.repository.StudentRepository;
import org.example.mongodbdemo.service.StudentApiInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentApiInterface {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllUrls() {
        return studentRepository.findAll();
    }

    @Override
    public Student getUrlById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteUrlById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(String id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        return studentRepository.save(existing);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
