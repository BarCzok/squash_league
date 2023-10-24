package com.praktyki.squash.repository;

import com.praktyki.squash.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayersRepository extends CrudRepository<Player, Integer> {
}
