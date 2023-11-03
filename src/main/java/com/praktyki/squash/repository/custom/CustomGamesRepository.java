package com.praktyki.squash.repository.custom;

import com.praktyki.squash.model.Game;
import com.praktyki.squash.model.Groupss;

import java.util.List;
import java.util.Map;

public interface CustomGamesRepository {
    Map<Groupss, List<Game>> getGamesInGroups(int roundId);
}