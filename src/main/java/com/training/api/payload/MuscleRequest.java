package com.training.api.payload;

import lombok.Data;

import java.util.List;

@Data
public class MuscleRequest {
    private String name;
    private List<Integer> exerciseIds;
}
