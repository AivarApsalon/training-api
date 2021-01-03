package com.training.api.service;

import com.training.api.entity.ExerciseType;
import com.training.api.repository.ExerciseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseTypeService {
    @Autowired
    private final ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    public ExerciseTypeService(ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    public ExerciseType createExercise(ExerciseType type) {
        return exerciseTypeRepository.save(type);
    }

    public ExerciseType getById(Integer id) {
        return this.exerciseTypeRepository.findById(id).orElseThrow();
    }

    public List<ExerciseType> getAllTypes() {
        return this.exerciseTypeRepository.findAll();
    }
}
