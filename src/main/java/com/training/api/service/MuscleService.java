package com.training.api.service;

import com.training.api.entity.Exercise;
import com.training.api.entity.Muscle;
import com.training.api.entity.dto.ExerciseDto;
import com.training.api.entity.dto.MuscleDto;
import com.training.api.payload.MuscleRequest;
import com.training.api.repository.ExerciseRepository;
import com.training.api.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuscleService {

    @Autowired
    private final MuscleRepository muscleRepository;

    @Autowired
    private final ExerciseRepository exerciseRepository;

    public MuscleService(MuscleRepository muscleRepository, ExerciseRepository exerciseRepository, ExerciseService exerciseService) {
        this.muscleRepository = muscleRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public MuscleDto createMuscle(MuscleRequest muscleRequest) throws Exception {
        List<Exercise> exercises = new ArrayList<>();

        List<Integer> exercisesIds = muscleRequest.getExerciseIds();
        List<ExerciseDto> exerciseDtos = new ArrayList<>();
        for (Integer exerciseId : exercisesIds) {
            Exercise exercise = this.exerciseRepository
                    .findById(exerciseId)
                    .orElseThrow(() -> new Exception("Could not find exercise with id " + exerciseId));
            ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
            exerciseDtos.add(exerciseDto);
            exercises.add(exercise);
        }

        String newMuscleName = muscleRequest.getName();
        Muscle newMuscle = new Muscle(newMuscleName, exercises);
        Muscle savedMuscle = this.muscleRepository.save(newMuscle);

        return mapMuscleDto(savedMuscle);
    }

    private static MuscleDto mapMuscleDto(Muscle muscle) {
        MuscleDto muscleDto = new MuscleDto();
        muscleDto.setId(muscle.getId());
        muscleDto.setName(muscle.getName());
        List<Exercise> exercises = muscle.getExercises();

        List<ExerciseDto> exerciseDtos = new ArrayList<>();
        for(Exercise exercise : exercises) {
            ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
            exerciseDtos.add(exerciseDto);
        }
        muscleDto.setExercises(exerciseDtos);

        return muscleDto;
    }

    public MuscleDto getById(Integer id) throws Exception {
        Muscle muscle = this.muscleRepository.findById(id)
                .orElseThrow(() -> new Exception("Could not find muscle with id " + id));

        return mapMuscleDto(muscle);
    }

    public List<Muscle> getAllCategories() {
        return this.muscleRepository.findAll();
    }
}
