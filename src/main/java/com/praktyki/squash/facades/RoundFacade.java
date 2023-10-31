package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.facades.dto.RoundDTO;
import com.praktyki.squash.model.Game;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.model.Round;
import com.praktyki.squash.repository.RoundRepository;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RoundFacade {

    @Resource
    GameFacade gameFacade;

    @Resource
    RoundRepository roundRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //Bartek w SQL
    public Map<GroupDTO, List<GameDTO>> getGamesForRoundSQL(int roundId){
        Query query = entityManager.createQuery("select distinct h.groupp from History as h where h.round.id = :roundId");
        query.setParameter("roundId", roundId);

        List<Groupss> groups = query.getResultList();

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

        Map<Groupss, List<Game>> games4groups = new HashMap<>();

        groups.forEach(group -> {
            query1.setParameter("roundId", roundId);
            query1.setParameter("groupId", group.getId());

            List<Game> resultList = query1.getResultList();

            games4groups.put(group, resultList);
        });

        return null;
    }

//    public Category findByName(String categoryName) {
//        Query query = entityManager.createQuery("SELECT
//    g.game_id
//FROM
//    games g
//        INNER JOIN
//    rounds r ON g.round_id = r.round_id
//        INNER JOIN
//    history h ON r.round_id = h.round_id and h.player_id = g.player1
//    where h.group_id = 1 and h.round_id = 1;
//
//        return (Category) query.getSingleResult();
//    }

    //Wojtek obiektowo
    public Map<GroupDTO, List<GameDTO>> getGamesForRoundObject(int roundId){
        HashMap<GroupDTO, List<GameDTO>> gamesForRound = new HashMap<>();

        return gamesForRound;
    }

    public List<GameDTO> getGamesForRound(int roundId){
        Round round = roundRepository.findById(roundId).get();

        return gameFacade.convertGames(round.getGames());
    }

    public List<RoundDTO> getRounds(){
        Iterable<Round> rounds = roundRepository.findAll();

        return (List<RoundDTO>) convertRound(rounds);
    }

    private List<RoundDTO> convertRound(Iterable<Round> rounds) {
        List<RoundDTO> roundDtos = new ArrayList<>();

        rounds.forEach(x -> roundDtos.add(convertRound(x)));

        return roundDtos;
    }

    public RoundDTO convertRound(Round rounds) {
        RoundDTO roundDto = new RoundDTO();

        roundDto.setId(rounds.getId());
        roundDto.setName(rounds.getName());

        return roundDto;
    }

    public RoundDTO getRoundById(Integer roundId) {
        Round round = roundRepository.findById(roundId).get();
        return convertRound(round);
    }
}