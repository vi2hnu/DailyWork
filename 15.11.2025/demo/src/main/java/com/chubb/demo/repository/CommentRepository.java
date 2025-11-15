package com.chubb.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.chubb.demo.DTO.Comments;

public interface CommentRepository extends CrudRepository<Comments, Long> {

}
