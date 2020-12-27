package com.training.api.repository;

import com.training.api.entity.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, Integer> {

}
