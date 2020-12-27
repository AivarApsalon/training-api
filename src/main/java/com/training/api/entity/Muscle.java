package com.training.api.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
