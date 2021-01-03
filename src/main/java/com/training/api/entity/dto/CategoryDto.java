package com.training.api.entity.dto;

import com.training.api.entity.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<ExerciseDto> exercises;
}
