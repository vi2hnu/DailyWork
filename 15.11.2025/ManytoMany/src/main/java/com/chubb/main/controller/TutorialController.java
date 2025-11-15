package com.chubb.main.controller;

import com.chubb.main.models.Tutorial;
import com.chubb.main.repository.TutorialRepository;
import com.chubb.main.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private TutorialRepository tutorialRepository;

    @PostMapping("/tutorial")
    public Tutorial saveTutorial(@RequestBody Tutorial tutorial){
        return tutorialService.saveTutorial(tutorial);
    }

}
