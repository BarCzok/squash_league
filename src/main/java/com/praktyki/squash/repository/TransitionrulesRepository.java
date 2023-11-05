package com.praktyki.squash.repository;

import com.praktyki.squash.model.TransitionRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransitionrulesRepository extends CrudRepository<TransitionRule, Integer> {
}
