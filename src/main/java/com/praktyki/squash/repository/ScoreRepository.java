package com.praktyki.squash.repository;

import com.praktyki.squash.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ScoreRepository extends CrudRepository<Score, Integer> {
}
