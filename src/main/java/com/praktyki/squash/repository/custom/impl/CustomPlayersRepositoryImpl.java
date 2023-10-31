package com.praktyki.squash.repository.custom.impl;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.custom.CustomPlayersRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomPlayersRepositoryImpl implements CustomPlayersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Map<Groupss, List<Player>> getPlayersInGroups(int roundId){
        Query query = entityManager.createQuery("select distinct h.groupp from History as h where h.round.id = :roundId");
        query.setParameter("roundId", roundId);

        List<Groupss> groups = query.getResultList();

        Query query1 = entityManager.createQuery("SELECT " +
                "    h.player " +
                "FROM " +
                "    Round as r " +
                "        INNER JOIN " +
                "    History as h ON r.id = h.round.id" +
                "    where h.groupp.id=:groupId and h.round.id=:roundId"
        );

        Map<Groupss, List<Player>> players4groups = new HashMap<>();

        groups.forEach(group -> {
            query1.setParameter("roundId", roundId);
            query1.setParameter("groupId", group.getId());

            List<Player> resultList = query1.getResultList();

            players4groups.put(group, resultList);
        });

        return players4groups;
    }
}
