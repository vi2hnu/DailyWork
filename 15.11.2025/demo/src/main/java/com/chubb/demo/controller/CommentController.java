package com.chubb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.demo.DTO.Comments;
import com.chubb.demo.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService service;
	
    @PostMapping("/comment")
    Comments comment(@RequestBody Comments comment) {
        return service.saveComment(comment);
    }
}
