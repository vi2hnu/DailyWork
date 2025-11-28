package org.example.quiz.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Response {
    @Id
    private String id;
    private String rightAnswer;
}