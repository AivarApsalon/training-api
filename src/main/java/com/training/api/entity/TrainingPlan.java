package com.training.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private String name;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ExerciseTrainingPlan> exercisesTrainingPlan = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date modifyDate;

    public TrainingPlan(String name, List<ExerciseTrainingPlan> exerciseTrainingPlans) {
        this.name = name;
        for(ExerciseTrainingPlan exerciseTrainingPlan : exerciseTrainingPlans) {
            exerciseTrainingPlan.setTrainingPlan(this);
        }
        this.exercisesTrainingPlan = exerciseTrainingPlans;
    }
}
