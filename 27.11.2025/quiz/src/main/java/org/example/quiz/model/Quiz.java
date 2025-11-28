package org.example.quiz.model;

import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Quiz")
@Data
public class Quiz {

    @Id
    private String id;

    private String title;

    private List<String> questionIds;
}