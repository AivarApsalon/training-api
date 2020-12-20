package com.training.api.domain;

import javax.persistence.*;

@Entity
public class MuscleGroup {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @ManyToOne
    private Muscle muscle;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
