package org.example.mongodbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "student")
public class Student {

    @Id
    private String id;

    private String name;
    private int age;


}
