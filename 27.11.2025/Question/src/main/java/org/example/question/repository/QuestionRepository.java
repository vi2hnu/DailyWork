package org.example.question.repository;

import org.example.question.model.Question;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByCategory(String category);

    @Aggregation(pipeline = {
            "{ '$match': { 'category': ?0 } }",
            "{ '$sample': { 'size': ?1 } }"
    })
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}