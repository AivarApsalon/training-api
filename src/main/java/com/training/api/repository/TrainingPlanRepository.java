package com.training.api.repository;

import com.training.api.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Integer> {
}
