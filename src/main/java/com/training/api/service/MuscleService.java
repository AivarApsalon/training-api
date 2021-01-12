package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.Muscle;
import com.training.api.payload.MuscleRequest;
import com.training.api.repository.ExerciseRepository;
import com.training.api.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleService {

    @Autowired
    private final MuscleRepository muscleRepository;

    @Autowired
    private final ExerciseRepository exerciseRepository;

    public MuscleService(MuscleRepository muscleRepository, ExerciseRepository exerciseRepository) {
        this.muscleRepository = muscleRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public Muscle createMuscle(MuscleRequest muscleRequest) throws Exception {
        int exerciseId = muscleRequest.getExerciseId();
        Exercise exercise = this.exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new Exception("Could not find related exercise with id " + exerciseId));

        Muscle muscle = new Muscle(muscleRequest.getName(), exercise);
        return this.muscleRepository.save(muscle);
    }

    public Muscle getById(Integer id) throws Exception {
        return this.muscleRepository.findById(id)
                .orElseThrow(() -> new Exception("Could not find muscle with id " + id));
    }

    public List<Muscle> getAllCategories() {
        return this.muscleRepository.findAll();
    }
}
