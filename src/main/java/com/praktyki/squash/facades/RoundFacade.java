package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.*;
import com.praktyki.squash.model.*;
import com.praktyki.squash.repository.*;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component
public class RoundFacade {

    @Resource
    GameFacade gameFacade;

    @Resource
    PlayerFacade playerFacade;

    @Resource
    GroupFacade groupFacade;

    @Resource
    RoundRepository roundRepository;
    @Resource
    PlayersRepository playersRepository;

    @Resource
    GameRepository gamesRepository;

    @Resource
    GroupssRepository groupssRepository;
    @Resource
    private HistoryRepository historyRepository;


    public Map<GroupDTO, List<PlayerDTO>> getPlayersInGroups(int roundId){
        Map<Groupss, List<Player>> playersInGroupsSQL = playersRepository.getPlayersInGroups(roundId);

        Map<GroupDTO, List<PlayerDTO>> result = new TreeMap<>();
        playersInGroupsSQL.forEach( (group, players ) -> {
            GroupDTO groupDTO = groupFacade.convertGroupss(group);
            List<PlayerDTO> playerDTOS = playerFacade.convertPlayers(players);

            for (PlayerDTO playerDTO : playerDTOS) {
                List<GameDTO> playersGames = getPlayerGames(roundId, groupDTO.getId(), playerDTO.getId());
                int points = getTotalPoints(playersGames, playerDTO.getId());
                playerDTO.setTotalPoints(points);
            }

            playerDTOS.sort((p1, p2) -> p2.getTotalPoints() - p1.getTotalPoints());

            List<TransitionRule> transitionRules = groupssRepository.getTransitionRules(group);

            int placeInGroup=1;
            for (PlayerDTO playerDTO : playerDTOS) {
                TransitionRule tr = getTransitionRuleForPlace(placeInGroup, transitionRules);
                playerDTO.setNextGroup(groupFacade.convertGroupss(tr.getTargetGroup()));
                playerDTO.setPlaceInGroup(placeInGroup);

                placeInGroup++;
            }

            result.put(groupDTO, playerDTOS);
        });
     return result;
    }

    private TransitionRule getTransitionRuleForPlace(int placeInGroup, List<TransitionRule> transitionRules) {
        for (TransitionRule transitionRule : transitionRules) {
            if(transitionRule.getPosition() == placeInGroup){
                return transitionRule;
            }
        }

        throw new IllegalStateException("Trasition rule mising!");
    }

    public int getTotalPoints(List<GameDTO> playersGames, int playerId) {
        int totalPoints = 0;
        for (GameDTO playersGame : playersGames) {
            ScoreDTO scoreDTO = null;
            if(playersGame.getPlayer1().getId()==playerId){
                scoreDTO = playersGame.getScores().isEmpty() ? new ScoreDTO() : playersGame.getScores().get(0);
            }
            if(playersGame.getPlayer2().getId()==playerId){
                scoreDTO = playersGame.getScores().isEmpty() ? new ScoreDTO() : playersGame.getScores().get(1);
            }

            totalPoints += scoreDTO.getTotalPoints();
        }
        return totalPoints;
    }

    private List<GameDTO> getPlayerGames(int roundId, int groupId, int playerId) {
        Map<GroupDTO, List<GameDTO>> gamesForRound = getGamesForRound(roundId);

        List<GameDTO> result = new ArrayList<>();
        for (Map.Entry<GroupDTO, List<GameDTO>> entry : gamesForRound.entrySet()) {
            GroupDTO group = entry.getKey();
            if (group.getId() == groupId) {
                for (GameDTO gameDTO : entry.getValue()) {
                    if(gameDTO.getPlayer1().getId() == playerId){
                        result.add(gameDTO);
                    }
                    if(gameDTO.getPlayer2().getId() == playerId){
                        result.add(gameDTO);
                    }
                }
            }
        }
        return result;
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
        roundDto.setStartDate(rounds.getStartDate());
        roundDto.setEndDate(rounds.getEndDate());

        return roundDto;
    }

    public RoundDTO getRoundById(Integer roundId) {
        Round round = roundRepository.findById(roundId).get();
        return convertRound(round);
    }


    public void closeRound(Integer roundId) {
        Round nextRound = new Round();
        nextRound.setStartDate(null);
        nextRound.setEndDate(null);
        nextRound.setName("nowa runda");
        roundRepository.save(nextRound);

        Map<GroupDTO, List<PlayerDTO>> playersInGroups = getPlayersInGroups(roundId);

        playersInGroups.forEach( (group, players ) -> {

        players.forEach(player -> {
            History h = new History();

            h.setPlayer(playersRepository.findById(player.getId()).get());
            h.setGroupp(groupssRepository.findById(player.getNextGroup().getId()).get());
            h.setRound(nextRound);

            historyRepository.save(h);
        });

        });

        createGames(nextRound);
    }

    public List<Game> createGames(Round round) {
        List<Game> games = new ArrayList<>();

        Map<Groupss, List<Player>> playersInGroups = playersRepository.getPlayersInGroups(round.getId());

        for(Groupss group : playersInGroups.keySet()) {
            List<Player> playersFromGroup = playersInGroups.get(group);
            for (int i = 0; i < playersFromGroup.size(); i++) {
                for (int j = 0; j < playersFromGroup.size(); j++) {
                    if (i > j) {
                        Game game = new Game();
                        game.setPlayer1(playersFromGroup.get(i));
                        game.setPlayer2(playersFromGroup.get(j));
                        game.setRound(round);
                        games.add(game);
                    }
                }
            }
        }
        gamesRepository.saveAll(games);

        return games;
    }
}