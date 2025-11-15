package com.chubb.demo.service;

import com.chubb.demo.DTO.Post;
import com.chubb.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
