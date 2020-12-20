package com.training.api.service;

import com.training.api.controller.ExerciseDto;
import com.training.api.domain.Exercise;
import com.training.api.repo.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void createExercise(ExerciseDto exerciseDto) {
        Exercise newExercise = new Exercise(exerciseDto.getName(), exerciseDto.getLevel());
        exerciseRepository.save(newExercise);
    }
}
