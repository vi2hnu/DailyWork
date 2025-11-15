package com.chubb.main.repository;

import com.chubb.main.models.Tutorial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TutorialRepository extends CrudRepository<Tutorial, Long> {
    List<Tutorial> findTutorialsByTagsId(int tagId);

}
