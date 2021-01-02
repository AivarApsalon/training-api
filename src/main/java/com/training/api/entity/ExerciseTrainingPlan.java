package com.training.api.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ExerciseTrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    @CreationTimestamp
    @Column()
    private Date created;

    public ExerciseTrainingPlan(Exercise exercise, Date createdDate) {
        this.exercise = exercise;
        this.created = createdDate;
    }
}
