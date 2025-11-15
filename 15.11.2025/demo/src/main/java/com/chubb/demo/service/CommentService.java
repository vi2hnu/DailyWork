package com.chubb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubb.demo.DTO.Comments;
import com.chubb.demo.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comments saveComment(Comments comment) {
        
    	return commentRepository.save(comment);
    }
}
