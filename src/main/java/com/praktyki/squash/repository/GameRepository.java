package com.praktyki.squash.repository;

import com.praktyki.squash.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameRepository extends CrudRepository<Game, Integer> {
}
