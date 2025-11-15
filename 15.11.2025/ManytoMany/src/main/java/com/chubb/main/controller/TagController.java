package com.chubb.main.controller;

import com.chubb.main.models.Tag;
import com.chubb.main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @PostMapping("/tag")
    public Tag updateTag(@RequestBody Tag tag){
        return tagRepository.save(tag);
    }
}
