package com.praktyki.squash.repository;

import com.praktyki.squash.model.Game;
import com.praktyki.squash.repository.custom.CustomGamesRepository;
import com.praktyki.squash.repository.custom.impl.CustomGamesRepositoryImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameRepository extends CrudRepository<Game, Integer>, CustomGamesRepository {
}
