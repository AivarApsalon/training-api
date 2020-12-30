package com.training.api.controller;

import com.training.api.entity.ExerciseCategory;
import com.training.api.entity.ExerciseType;
import com.training.api.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class ExerciseCategoryController {

    private final ExerciseCategoryService exerciseCategoryService;

    @Autowired
    public ExerciseCategoryController(ExerciseCategoryService exerciseCategoryService) {
        this.exerciseCategoryService = exerciseCategoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExerciseCategory> create(@RequestBody ExerciseCategory category) {
        ExerciseCategory newCategory = this.exerciseCategoryService.createExerciseCategory(category);

        return ResponseEntity.ok(newCategory);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExerciseCategory> getById(@PathVariable Integer id) {
        ExerciseCategory category = this.exerciseCategoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<ExerciseCategory>> getAll() {
        List<ExerciseCategory> types = this.exerciseCategoryService.getAllCategories();
        return ResponseEntity.ok(types);
    }
}
