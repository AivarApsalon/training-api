package com.training.api.controller;

import com.training.api.entity.ExerciseType;
import com.training.api.entity.dto.TypeDto;
import com.training.api.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise-type")
public class ExerciseTypeController {

    @Autowired
    private final ExerciseTypeService exerciseTypeService;

    @Autowired
    public ExerciseTypeController(ExerciseTypeService exerciseTypeService) {
        this.exerciseTypeService = exerciseTypeService;
    }

    @PostMapping
    public ResponseEntity<ExerciseType> create(@RequestBody ExerciseType type) {
        ExerciseType newType = this.exerciseTypeService.createExercise(type);
        return ResponseEntity.ok(newType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getById(@PathVariable Integer id) {
        TypeDto type = this.exerciseTypeService.getById(id);
        return ResponseEntity.ok(type);
    }

    @GetMapping
    public ResponseEntity<List<TypeDto>> getAll() {
        List<TypeDto> types = this.exerciseTypeService.getAllTypes();
        return ResponseEntity.ok(types);
    }
}
