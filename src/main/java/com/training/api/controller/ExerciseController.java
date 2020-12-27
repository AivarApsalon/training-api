package com.training.api.controller;

import com.training.api.entity.Exercise;
import com.training.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exercise/")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createExercise(@RequestBody Exercise exerciseDto) {
        this.exerciseService.createExercise(exerciseDto);
    }
}
