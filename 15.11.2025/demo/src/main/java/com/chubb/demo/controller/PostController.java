package com.chubb.demo.controller;

import com.chubb.demo.DTO.Post;
import com.chubb.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    Post post(@RequestBody Post post) {
        return postService.savePost(post);
    }

}
