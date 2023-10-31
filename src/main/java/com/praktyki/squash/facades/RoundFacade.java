package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.facades.dto.RoundDTO;
import com.praktyki.squash.model.Round;
import com.praktyki.squash.repository.RoundRepository;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;
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

    //Bartek w SQL
    public Map<GroupDTO, List<GameDTO>> getGamesForRoundSQL(int roundId){
        HashMap<GroupDTO, List<GameDTO>> gamesForRound = new HashMap<>();

        return gamesForRound;
    }

//    public Category findByName(String categoryName) {
//        Query query = entityManager.createQuery("select c from Category as c where c.name = :categoryName");
//        query.setParameter("categoryName", categoryName);
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