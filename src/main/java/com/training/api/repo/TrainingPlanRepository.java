package com.training.api.repo;

import com.training.api.domain.TrainingPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "training-plan", path = "training-plan")
public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Integer> {
}
