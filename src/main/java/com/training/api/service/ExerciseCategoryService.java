package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseCategory;
import com.training.api.entity.ExerciseType;
import com.training.api.entity.dto.CategoryDto;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.entity.dto.TypeDto;
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

        return mapCategoryDto(category);
    }

    public List<CategoryDto> getAllCategories() {
        List<ExerciseCategory> categories = this.exerciseCategoryRepository.findAll();

        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(ExerciseCategory category : categories) {
            CategoryDto typeDto = mapCategoryDto(category);
            categoryDtos.add(typeDto);
        }
        return categoryDtos;
    }

    public static CategoryDto mapCategoryDto(ExerciseCategory category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        List<Exercise> typeExercises = category.getExercises();
        if (typeExercises != null) {
            List<ExerciseDto> categoryExercisesDto = new ArrayList<>();
            for(Exercise exercise : typeExercises) {
                ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
                categoryExercisesDto.add(exerciseDto);
            }
            categoryDto.setExercises(categoryExercisesDto);
        }

        return categoryDto;
    }
}
