package com.praktyki.squash.repository;

import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.custom.CustomPlayersRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


public interface PlayersRepository extends CrudRepository<Player, Integer>, CustomPlayersRepository {
}
