package org.example.question.repository;

import org.example.question.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByCategory(String category);
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
