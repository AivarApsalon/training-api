package com.training.api.repo;

import com.training.api.domain.ExerciseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "exercise-category", path = "exercise-category")
public interface ExerciseCategoryRepository extends CrudRepository<ExerciseCategory, Integer> {
}
