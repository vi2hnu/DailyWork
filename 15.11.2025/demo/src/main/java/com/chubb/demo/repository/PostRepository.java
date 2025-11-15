package com.chubb.demo.repository;

import com.chubb.demo.DTO.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
