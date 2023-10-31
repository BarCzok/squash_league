package com.praktyki.squash.repository.custom.impl;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.model.Game;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.repository.custom.CustomGamesRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomGamesRepositoryImpl implements CustomGamesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Map<Groupss, List<Game>> getGamesForRoundSQL(int roundId){
        Query query = entityManager.createQuery("select distinct h.groupp from History as h where h.round.id = :roundId");
        query.setParameter("roundId", roundId);

        List<Groupss> groups = query.getResultList();



        Map<Groupss, List<Game>> games4groups = new HashMap<>();

        groups.forEach(group -> {
            Query query1 = entityManager.createQuery("SELECT " +
                    "    g " +
                    "FROM " +
                    "    Game as g " +
                    "        INNER JOIN " +
                    "    Round as r ON g.round.id = r.id " +
                    "        INNER JOIN " +
                    "    History as h ON r.id = h.round.id and h.player.id = g.player1.id " +
                    "    where h.groupp.id=:groupId and h.round.id=:roundId"
            );
            query1.setParameter("roundId", roundId);
            query1.setParameter("groupId", group.getId());
            List<Game> resultList = query1.getResultList();

            games4groups.put(group, resultList);
        });

        return games4groups;
    }
}
