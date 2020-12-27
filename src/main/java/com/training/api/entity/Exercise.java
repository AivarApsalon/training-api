package com.training.api.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    private Level level;

    @Column(length = 5000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_category_id")
    private ExerciseCategory exerciseCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_type_id")
    private ExerciseType exerciseType;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    public Exercise() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
