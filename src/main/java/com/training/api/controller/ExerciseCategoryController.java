package com.training.api.controller;

import com.training.api.entity.ExerciseCategory;
import com.training.api.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category/")
public class ExerciseCategoryController {

    private final ExerciseCategoryService exerciseCategoryService;

    @Autowired
    public ExerciseCategoryController(ExerciseCategoryService exerciseCategoryService) {
        this.exerciseCategoryService = exerciseCategoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createExerciseCategory(@RequestBody ExerciseCategory category) {
        this.exerciseCategoryService.createExerciseCategory(category);
    }
}
