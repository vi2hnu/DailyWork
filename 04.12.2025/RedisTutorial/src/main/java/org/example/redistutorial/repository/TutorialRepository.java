package org.example.redistutorial.repository;

import org.example.redistutorial.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial> getAllTutorials();
    List<Tutorial> getAllByCategory(String category);
}
