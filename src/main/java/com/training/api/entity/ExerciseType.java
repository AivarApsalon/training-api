package com.training.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "exerciseType", cascade = CascadeType.ALL)
    private Set<Exercise> exercises = new HashSet<>();
}
