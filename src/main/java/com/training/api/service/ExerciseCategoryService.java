package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseCategory;
import com.training.api.repository.ExerciseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseCategoryService {
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseCategoryService(ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public ExerciseCategory createExerciseCategory(ExerciseCategory category) {
        return this.exerciseCategoryRepository.save(category);
    }

    public ExerciseCategory getById(Integer id) {
        return this.exerciseCategoryRepository.findById(id).orElseThrow();
    }

    public List<ExerciseCategory> getAllCategories() {
        return this.exerciseCategoryRepository.findAll();
    }
}
