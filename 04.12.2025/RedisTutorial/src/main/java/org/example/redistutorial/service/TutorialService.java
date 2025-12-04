package org.example.redistutorial.service;

import org.example.redistutorial.model.Tutorial;
import org.example.redistutorial.repository.TutorialRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Cacheable("tutorial")
    public List<Tutorial> getAllTutorial(){
        return tutorialRepository.getAllTutorials();
    }

    @Cacheable("category")
    public List<Tutorial> getByCategory(String category){
        return tutorialRepository.getAllByCategory(category);
    }
}
