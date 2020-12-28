package com.training.api.payload;

import com.training.api.entity.Level;
import lombok.Data;

@Data
public class ExerciseRequest {
    private String name;
    private Level level;
    private String description;
    private int categoryId;
}
