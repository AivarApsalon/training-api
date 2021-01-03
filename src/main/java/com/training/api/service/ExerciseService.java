package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseType;
import com.training.api.payload.ExerciseRequest;
import com.training.api.repository.ExerciseCategoryRepository;
import com.training.api.repository.ExerciseRepository;
import com.training.api.repository.ExerciseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;
    @Autowired
    private final ExerciseCategoryRepository exerciseCategoryRepository;
    @Autowired
    private final ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseCategoryRepository exerciseCategoryRepository, ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    public Exercise createExercise(ExerciseRequest exerciseRequest) throws Exception {
        int typeId = exerciseRequest.getTypeId();
        ExerciseType type = this.exerciseTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new Exception("Category type not found id = " + typeId));

        Exercise exercise = new Exercise(exerciseRequest.getName(), exerciseRequest.getLevel(), exerciseRequest.getDescription());
        exercise.setExerciseType(type);
        return this.exerciseRepository.save(exercise);
    }
}
