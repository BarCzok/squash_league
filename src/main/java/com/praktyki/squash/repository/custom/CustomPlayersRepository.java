package com.praktyki.squash.repository.custom;

import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.Player;

import java.util.List;
import java.util.Map;

public interface CustomPlayersRepository {

    Map<Groupss, List<Player>> getPlayersInGroups(int roundId);
}
