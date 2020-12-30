package com.training.api.repository;

import com.training.api.entity.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer> {
}
