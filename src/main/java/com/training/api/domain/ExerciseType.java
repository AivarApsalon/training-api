package com.training.api.domain;

import javax.persistence.*;

@Entity
public class ExerciseType {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
