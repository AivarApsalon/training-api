package com.training.api.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class MuscleDto {
    private int id;
    private String name;
    private List<ExerciseDto> exercises;
}
