package com.chubb.main.service;

import com.chubb.main.models.Tutorial;
import com.chubb.main.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial saveTutorial(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }
}
