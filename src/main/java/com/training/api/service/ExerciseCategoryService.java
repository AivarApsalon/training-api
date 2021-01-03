package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseCategory;
import com.training.api.entity.dto.CategoryDto;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.repository.ExerciseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseCategoryService {
    @Autowired
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseCategoryService(ExerciseCategoryRepository exerciseCategoryRepository, ExerciseService exerciseService) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public ExerciseCategory createExerciseCategory(ExerciseCategory category) {
        return this.exerciseCategoryRepository.save(category);
    }

    public CategoryDto getById(Integer id) {
        ExerciseCategory category = this.exerciseCategoryRepository.findById(id).orElseThrow();

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        List<Exercise> categoryExercises = category.getExercises();
        if (categoryExercises != null) {
            List<ExerciseDto> categoryExercisesDto = new ArrayList<>();
            for(Exercise exercise : categoryExercises) {
                ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
                categoryExercisesDto.add(exerciseDto);
            }
            categoryDto.setExercises(categoryExercisesDto);
        }

        return categoryDto;
    }

    public List<ExerciseCategory> getAllCategories() {
        return this.exerciseCategoryRepository.findAll();
    }
}
