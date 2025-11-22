package org.example.mongodbdemowebflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;

    private String name;
    private int age;


}
