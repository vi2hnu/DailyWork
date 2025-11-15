package com.chubb.main.repository;

import com.chubb.main.models.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findTagsByTutorialsId(Long tutorialId);
}
