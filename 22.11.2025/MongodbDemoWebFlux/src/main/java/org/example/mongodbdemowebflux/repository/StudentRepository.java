package org.example.mongodbdemowebflux.repository;

import org.example.mongodbdemowebflux.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepository extends ReactiveMongoRepository<Student,String> {

}
