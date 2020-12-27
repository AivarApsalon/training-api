package com.training.api.service;

import com.training.api.entity.Exercise;
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

    public void createExercise(Exercise exerciseDto) {
//        Exercise newExercise = new Exercise(exerciseDto.getName(), exerciseDto.getLevel(), exerciseDto.getDescription(), exerciseDto.getExerciseCategory());
//        exerciseRepository.save(newExercise);
    }
}
