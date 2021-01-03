package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.ExerciseCategory;
import com.training.api.entity.ExerciseType;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.entity.dto.TypeDto;
import com.training.api.payload.ExerciseRequest;
import com.training.api.repository.ExerciseCategoryRepository;
import com.training.api.repository.ExerciseRepository;
import com.training.api.repository.ExerciseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;
    @Autowired
    private final ExerciseCategoryRepository exerciseCategoryRepository;
    @Autowired
    private final ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseCategoryRepository exerciseCategoryRepository, ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    public ExerciseDto createExercise(ExerciseRequest exerciseRequest) throws Exception {
        Exercise exercise = new Exercise(exerciseRequest.getName(), exerciseRequest.getLevel(), exerciseRequest.getDescription());

        addTypeToExercise(exerciseRequest, exercise);
        addCategoryToExercise(exerciseRequest, exercise);

        Exercise newExercise = this.exerciseRepository.save(exercise);

        ExerciseDto exerciseDto;
        exerciseDto = mapExerciseDto(newExercise);

        return exerciseDto;
    }

    public static ExerciseDto mapExerciseDto(Exercise exercise) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(exercise.getId());
        exerciseDto.setName(exercise.getName());
        exerciseDto.setLevel(exercise.getLevel());
        exerciseDto.setDescription(exercise.getDescription());
        exerciseDto.setCategoryId(exercise.getExerciseCategory().getId());
        exerciseDto.setCategoryName(exercise.getExerciseCategory().getName());
        exerciseDto.setTypeId(exercise.getExerciseType().getId());
        exerciseDto.setTypeName(exercise.getExerciseType().getName());
        exerciseDto.setCreated(exercise.getCreateDate());
        exerciseDto.setModified(exercise.getModifyDate());
        return  exerciseDto;
    }

    private void addCategoryToExercise(ExerciseRequest exerciseRequest, Exercise exercise) throws Exception {
        int categoryId = exerciseRequest.getCategoryId();
        if (categoryId > 0) {
            ExerciseCategory category = this.exerciseCategoryRepository
                    .findById(categoryId)
                    .orElseThrow(() -> new Exception("Exercise category not found id = " + categoryId));
            exercise.setExerciseCategory(category);
        }
    }

    private void addTypeToExercise(ExerciseRequest exerciseRequest, Exercise exercise) throws Exception {
        int typeId = exerciseRequest.getTypeId();
        if (typeId > 0) {
            ExerciseType type = this.exerciseTypeRepository
                    .findById(typeId)
                    .orElseThrow(() -> new Exception("Exercise type not found id = " + typeId));
            exercise.setExerciseType(type);
        }
    }

    public ExerciseDto getById(Integer id) throws Exception {
        Exercise exercise = this.exerciseRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Could not find exercise id = " + id));
        return mapExerciseDto(exercise);
    }

    public List<ExerciseDto> getAll() {
        List<Exercise> exercises = this.exerciseRepository.findAll();

        List<ExerciseDto> exerciseDtos = new ArrayList<>();
        for(Exercise exercise : exercises) {
            ExerciseDto exerciseDto = mapExerciseDto(exercise);
            exerciseDtos.add(exerciseDto);
        }
        return exerciseDtos;
    }
}
