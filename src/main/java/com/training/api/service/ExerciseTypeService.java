package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseType;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.entity.dto.TypeDto;
import com.training.api.repository.ExerciseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public TypeDto getById(Integer id) {
        ExerciseType type = this.exerciseTypeRepository.findById(id).orElseThrow();

        return mapTypeDto(type);
    }

    public List<TypeDto> getAllTypes() {
        List<ExerciseType> exerciseTypes = this.exerciseTypeRepository.findAll();

        List<TypeDto> typeDtos = new ArrayList<>();
        for(ExerciseType type : exerciseTypes) {
            TypeDto typeDto = mapTypeDto(type);
            typeDtos.add(typeDto);
        }
        return typeDtos;
    }

    public static TypeDto mapTypeDto(ExerciseType type) {
        TypeDto typeDto = new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());

        List<Exercise> typeExercises = type.getExercises();
        if (typeExercises != null) {
            List<ExerciseDto> categoryExercisesDto = new ArrayList<>();
            for(Exercise exercise : typeExercises) {
                ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
                categoryExercisesDto.add(exerciseDto);
            }
            typeDto.setExercises(categoryExercisesDto);
        }

        return typeDto;
    }
}
