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
        int exerciseId = muscleRequest.getExerciseId();
        Exercise exercise = this.exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new Exception("Could not find related exercise with id " + exerciseId));

        Muscle muscle = new Muscle(muscleRequest.getName(), exercise);

        Muscle savedMuscle = this.muscleRepository.save(muscle);

        return mapMuscleDto(savedMuscle);
    }

    private static MuscleDto mapMuscleDto(Muscle muscle) {
        MuscleDto muscleDto = new MuscleDto();
        muscleDto.setId(muscle.getId());
        muscleDto.setName(muscle.getName());

        Exercise exercise = muscle.getExercise();
        ExerciseDto exerciseDto = ExerciseService.mapExerciseDto(exercise);
        List<ExerciseDto> exerciseList = new ArrayList<>();
        exerciseList.add(exerciseDto);
        muscleDto.setExercises(exerciseList);

        return muscleDto;
    }

    public Muscle getById(Integer id) throws Exception {
        return this.muscleRepository.findById(id)
                .orElseThrow(() -> new Exception("Could not find muscle with id " + id));
    }

    public List<Muscle> getAllCategories() {
        return this.muscleRepository.findAll();
    }
}
