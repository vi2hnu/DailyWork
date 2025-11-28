package org.example.quiz.feign;

import org.example.quiz.model.QuestionWrapper;
import org.example.quiz.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("Question")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<String>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions );

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<String> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}