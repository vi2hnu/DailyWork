package org.example.mongodbdemo.repository;

import org.example.mongodbdemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {

}
