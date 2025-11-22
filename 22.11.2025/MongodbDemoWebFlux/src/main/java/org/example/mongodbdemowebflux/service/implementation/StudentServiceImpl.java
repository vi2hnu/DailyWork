package org.example.mongodbdemowebflux.service.implementation;

import org.example.mongodbdemowebflux.model.Student;
import org.example.mongodbdemowebflux.repository.StudentRepository;
import org.example.mongodbdemowebflux.service.StudentApiInterface;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentApiInterface {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<Student> getAllUrls() {
        return studentRepository.findAll();
    }

    @Override
    public Mono<Student> getUrlById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteUrlById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Mono<Student> updateStudent(String id, Student student) {
        return studentRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(student.getName());
                    existing.setAge(student.getAge());
                    return studentRepository.save(existing);
                });
    }

    @Override
    public Mono<Student> createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> addStudent(Student student) {
        return studentRepository.save(student);
    }
}
