package org.example.redistutorial.controller;

import io.lettuce.core.dynamic.annotation.Param;
import org.example.redistutorial.model.Tutorial;
import org.example.redistutorial.service.TutorialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {


    private final TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/all")
    public List<Tutorial> getAllTutorial(){
        return tutorialService.getAllTutorial();
    }

    @GetMapping("/{category}")
    public List<Tutorial> getByCategory(@PathVariable String category){
        return tutorialService.getByCategory(category);
    }
}
