package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.facades.dto.RoundDTO;
import com.praktyki.squash.model.Game;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.Round;
import com.praktyki.squash.repository.RoundRepository;

import com.praktyki.squash.repository.custom.CustomGamesRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.*;

@Component
public class RoundFacade {

    @Resource
    GameFacade gameFacade;

    @Resource
    GroupFacade groupFacade;

    @Resource
    RoundRepository roundRepository;

    @Resource
    CustomGamesRepository gamesRepository;

    public Map<GroupDTO, List<PlayerDTO>> getPlayrsForRound(int roundId){
        return new HashMap<>();
    }

    public Map<GroupDTO, List<GameDTO>> getGamesForRound(int roundId){
        Map<Groupss, List<Game>> gamesForRoundSQL = gamesRepository.getGamesInGroups(roundId);

        Map<GroupDTO, List<GameDTO>> result = new TreeMap<>();
        gamesForRoundSQL.forEach( (group, games) -> {
            GroupDTO groupDTO = groupFacade.convertGroupss(group);
            List<GameDTO> gameDTOS = gameFacade.convertGames(games);
            result.put(groupDTO, gameDTOS);
        });

        return result;
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