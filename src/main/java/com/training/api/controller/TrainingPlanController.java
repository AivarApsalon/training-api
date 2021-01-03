package com.training.api.controller;

import com.training.api.entity.TrainingPlan;
import com.training.api.entity.dto.TrainingPlanDto;
import com.training.api.payload.TrainingPlanRequest;
import com.training.api.service.TrainingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/training-plan")
public class TrainingPlanController {

    @Autowired
    private final TrainingPlanService trainingPlanService;

    @Autowired
    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @PostMapping
    public ResponseEntity<TrainingPlanDto> create(@RequestBody TrainingPlanRequest trainingPlan) throws Exception {
        TrainingPlanDto newTrainingPlan = this.trainingPlanService.createTrainingPlan(trainingPlan);
        return ResponseEntity.ok(newTrainingPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlan> getById(@PathVariable Integer id) throws Exception {
        TrainingPlan trainingPlan = this.trainingPlanService.getTrainingPlan(id);
        return ResponseEntity.ok(trainingPlan);
    }
}
