package com.training.api.domain;

import javax.persistence.*;

@Entity
public class ExerciseCategory {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany
    private Exercise exercise;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
