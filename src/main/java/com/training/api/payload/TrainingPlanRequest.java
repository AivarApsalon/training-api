package com.training.api.payload;

import lombok.Data;

import java.util.List;

@Data
public class TrainingPlanRequest {

    private String name;
    private List<Integer> exerciseIds;
}
