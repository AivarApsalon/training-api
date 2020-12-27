package com.training.api.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ExerciseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "exerciseCategory", cascade = CascadeType.ALL)
    private Set<Exercise> exercises = new HashSet<>();

    public ExerciseCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseCategory that = (ExerciseCategory) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(exercises, that.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, exercises);
    }

    @Override
    public String toString() {
        return "ExerciseCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exercise=" + exercises +
                '}';
    }
}
