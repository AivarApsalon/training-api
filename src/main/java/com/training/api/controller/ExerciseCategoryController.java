package com.training.api.controller;

import com.training.api.entity.ExerciseCategory;
import com.training.api.entity.dto.CategoryDto;
import com.training.api.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class ExerciseCategoryController {

    @Autowired
    private final ExerciseCategoryService exerciseCategoryService;

    @Autowired
    public ExerciseCategoryController(ExerciseCategoryService exerciseCategoryService) {
        this.exerciseCategoryService = exerciseCategoryService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExerciseCategory> create(@RequestBody ExerciseCategory category) {
        ExerciseCategory newCategory = this.exerciseCategoryService.createExerciseCategory(category);

        return ResponseEntity.ok(newCategory);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> getById(@PathVariable Integer id) {
        CategoryDto category = this.exerciseCategoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> types = this.exerciseCategoryService.getAllCategories();
        return ResponseEntity.ok(types);
    }
}
