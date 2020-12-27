package com.training.api.service;

import com.training.api.entity.ExerciseCategory;
import com.training.api.repository.ExerciseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseCategoryService {
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseCategoryService(ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public void createExerciseCategory(ExerciseCategory category) {
        // List<Exercise> exercisesSet = new LinkedList<>();
//        Exercise exercise = this.exerciseRepository.findById(categoryDto.getExerciseId())
//                .orElseThrow(() -> new NoSuchElementException("Tour does not exist "));
        // exercisesSet.add(exercise);
//        ExerciseCategory newExerciseCategory = new ExerciseCategory(category.getName());
//        this.exerciseCategoryRepository.save(newExerciseCategory);
    }
}
