package com.training.api.controller;

import com.training.api.domain.Level;

public class ExerciseDto {
    private String name;

    private Level level;

    public ExerciseDto(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
