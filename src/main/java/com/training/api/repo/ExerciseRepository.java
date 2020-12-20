package com.training.api.repo;

import com.training.api.domain.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "exercise", path = "exercise")
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

    Optional<Exercise> findByName(@Param("name")String name);
}
