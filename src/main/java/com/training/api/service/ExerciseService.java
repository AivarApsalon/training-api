package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseCategory;
import com.training.api.payload.ExerciseRequest;
import com.training.api.repository.ExerciseCategoryRepository;
import com.training.api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public Exercise createExercise(ExerciseRequest exerciseRequest) {
        Exercise exercise = new Exercise(exerciseRequest.getName(), exerciseRequest.getLevel(), exerciseRequest.getDescription());
        if(exerciseRequest.getCategoryId() > 0) {
            ExerciseCategory category = this.exerciseCategoryRepository
                    .findById(exerciseRequest.getCategoryId())
                    .orElseThrow();
            exercise.setExerciseCategory(category);
        }
        return this.exerciseRepository.save(exercise);
    }
}
