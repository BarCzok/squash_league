package com.praktyki.squash;

import com.praktyki.squash.model.*;
import com.praktyki.squash.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TestData {

    int roundsCount = 3;
    int playersCount = 2;
    private List<Player> players = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private List<History> histories = new ArrayList<>();

    @Resource
    PlayersRepository playersRepository;

    @Resource
    GameRepository gamesRepository;

    @Resource
    ScoreRepository scoreRepository;

    @Resource
    GroupssRepository groupssRepository;

    @Resource
    RoundRepository roundRepository;

    public void createPlayers() {
        for (int i = 0; i < playersCount; i++) {
            Player player = new Player();
            player.setName("Player" + i);
            player.setPhoneNumber(837349531 + i);
            player.setAdress("Rybnik Domowa "+ 10 + i);
            players.add(player);
        }

        playersRepository.saveAll(players);
    }

    public void createRound(){
        for (int i =0; i < roundsCount ; i++) {
            Round round = new Round();
            round.setName("Runda "+ i);
            rounds.add(round);
        }

        roundRepository.saveAll(rounds);
    }

    public void createGroupss() {
        Groupss groupss = new Groupss();
        groupss.setName("A");
        groupss.add(groupss);

        groupssRepository.save(groupss);
}

    public void createGames() {
        for(int i=0; i<players.size(); i++){
            for(int j=0; j<players.size(); j++){
                if(i>j){
                    Game game = new Game();
                    game.setPlayer1(players.get(i));
                    game.setPlayer2(players.get(j));
                    games.add(game);
                }
            }
        }
        gamesRepository.saveAll(games);
    }

    public void createScores() {
        for (Game game : games) {

            Random r = new Random();
            int player1Sets = r.nextInt(5);

            Score player1Score = new Score();
            player1Score.setSets(player1Sets);
            player1Score.setGame(game);
            player1Score.setPlayer(game.getPlayer1());
            scoreRepository.save(player1Score);

            Score player2Score = new Score();
            player2Score.setSets(5-player1Sets);
            player2Score.setGame(game);
            player2Score.setPlayer(game.getPlayer2());
            scoreRepository.save(player2Score);
        }
    }
}
