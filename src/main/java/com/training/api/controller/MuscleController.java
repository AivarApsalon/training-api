package com.training.api.controller;

import com.training.api.entity.Muscle;
import com.training.api.entity.dto.CategoryDto;
import com.training.api.entity.dto.MuscleDto;
import com.training.api.payload.MuscleRequest;
import com.training.api.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/muscle")
public class MuscleController {

    @Autowired
    private final MuscleService muscleService;


    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @PostMapping
    public ResponseEntity<MuscleDto> create(@RequestBody MuscleRequest muscleRequest) throws Exception {
        MuscleDto newMuscle = this.muscleService.createMuscle(muscleRequest);

        return ResponseEntity.ok(newMuscle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuscleDto> getById(@PathVariable Integer id) throws Exception {
        MuscleDto muscle = this.muscleService.getById(id);
        return ResponseEntity.ok(muscle);
    }

    @GetMapping
    public ResponseEntity<List<Muscle>> getAll() {
        List<Muscle> muscles = this.muscleService.getAllCategories();
        return ResponseEntity.ok(muscles);
    }
}
