package com.chubb.main.service;

import com.chubb.main.models.Tag;
import com.chubb.main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    Tag save(Tag tag){
        return tagRepository.save(tag);
    }
}
