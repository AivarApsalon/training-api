package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.TrainingPlan;
import com.training.api.payload.TrainingPlanRequest;
import com.training.api.repository.ExerciseRepository;
import com.training.api.repository.TrainingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingPlanService {
    @Autowired
    private final TrainingPlanRepository trainingPlanRepository;
    @Autowired
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public TrainingPlanService(TrainingPlanRepository trainingPlanRepository, ExerciseRepository exerciseRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public TrainingPlan createTrainingPlan(TrainingPlanRequest trainingPlan) throws Exception {
        List<Exercise> exercises = new ArrayList<>();

        List<Integer> exercisesIds = trainingPlan.getExerciseIds();
        for (Integer exerciseId : exercisesIds) {
            Exercise exercise = this.exerciseRepository
                    .findById(exerciseId)
                    .orElseThrow(() -> new Exception("Could not find exercise with id " + exerciseId));
            exercises.add(exercise);
        }
        String newTrainingPlanName = trainingPlan.getName();
        TrainingPlan newTrainingPlan = new TrainingPlan(newTrainingPlanName, exercises);
        return this.trainingPlanRepository.save(newTrainingPlan);
    }

    public TrainingPlan getTrainingPlan(Integer id) throws Exception {
        return this.trainingPlanRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Could not find training plan id = " + id));
    }
}
