package com.training.api.controller;

import com.training.api.entity.Exercise;
import com.training.api.payload.ExerciseRequest;
import com.training.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Exercise> create(@RequestBody ExerciseRequest exercise) {
        Exercise newExercise = this.exerciseService.createExercise(exercise);
        return ResponseEntity.ok(newExercise);
    }
}
