package com.training.api.domain;

import javax.persistence.*;

@Entity
public class TrainingPlan {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String name;

}
