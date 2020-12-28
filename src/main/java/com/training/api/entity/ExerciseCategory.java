package com.training.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
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
