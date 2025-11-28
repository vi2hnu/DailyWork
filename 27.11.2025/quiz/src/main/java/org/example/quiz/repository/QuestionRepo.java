package org.example.quiz.repository;

import org.example.quiz.model.Question;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo  extends MongoRepository<Question, String> {
    List<Question> findByCategory(String category);

	@Aggregation(pipeline = {
	        "{ $match: { category: ?0 } }",
	        "{ $sample: { size: ?1 } }"
	    })
    List<Question> findRandomQuestionByCategory(String category, int numQ);

}
