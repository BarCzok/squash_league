package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.model.Game;
import com.praktyki.squash.repository.GameRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameFacade {

    @Resource
    private GameRepository gameRepository;

    @Resource
    private PlayerFacade playerFacade;

    @Resource
    private ScoreFacade scoreFacade;

    @Resource
    private RoundFacade roundFacade;

    public List<GameDTO> getGames(){
        Iterable<Game> games = gameRepository.findAll();

        return convertGames(games);
    }

    public List<GameDTO> convertGames(Iterable<Game> games) {
        List<GameDTO> gameDtos = new ArrayList<>();

        games.forEach(game -> gameDtos.add(convertGame(game)));

        return gameDtos;
    }

    private GameDTO convertGame(Game game) {
        GameDTO gameDTO = new GameDTO();

        gameDTO.setId(game.getId());
        gameDTO.setPlayer1(playerFacade.convertPlayer(game.getPlayer1()));
        gameDTO.setPlayer2(playerFacade.convertPlayer(game.getPlayer2()));

        gameDTO.setScores(scoreFacade.convertScores(game.getScores()));
        gameDTO.setRound(roundFacade.convertRound(game.getRound()));

        return gameDTO;
    }

    public GameDTO getGame(Integer gameId) {
        return convertGame(gameRepository.findById(gameId).get());
    }
}
