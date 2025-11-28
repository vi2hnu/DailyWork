package org.example.quiz.repository;

import org.example.quiz.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  QuizRepo extends MongoRepository<Quiz, String> {
}
