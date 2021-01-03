package com.training.api.controller;

import com.training.api.entity.Exercise;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.entity.dto.TypeDto;
import com.training.api.payload.ExerciseRequest;
import com.training.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise")
public class ExerciseController {

    @Autowired
    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ResponseEntity<ExerciseDto> create(@RequestBody ExerciseRequest exercise) throws Exception {
        ExerciseDto exerciseDto = this.exerciseService.createExercise(exercise);
        return ResponseEntity.ok(exerciseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDto> findById(@PathVariable Integer id) throws Exception {
        ExerciseDto exerciseDto = this.exerciseService.getById(id);

        return ResponseEntity.ok(exerciseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExerciseDto>> getAll() {
        List<ExerciseDto> exercises = this.exerciseService.getAll();
        return ResponseEntity.ok(exercises);
    }
}
