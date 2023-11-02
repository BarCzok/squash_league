package com.praktyki.squash;

import com.praktyki.squash.model.*;
import com.praktyki.squash.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class TestData {

    int roundsCount = 1;
    int groupsCount = 3;
    int playersCount = 9;
    private List<Player> players = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private List<Groupss> groups = new ArrayList<>();
    private List<History> histories = new ArrayList<>();

    @Resource
    PlayersRepository playersRepository;

    @Resource
    GameRepository gamesRepository;

    @Resource
    ScoreRepository scoreRepository;

    @Resource
    GroupssRepository groupsRepository;

    @Resource
    RoundRepository roundRepository;
    @Resource
    HistoryRepository historyRepository;

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

        for(int i=0; i<groupsCount;i++) {
            Groupss group = new Groupss();
            group.setName("Grupa" + i);
            group.add(group);

            groups.add(group);
        }

        groupsRepository.saveAll(groups);
}

    public void createGames(Round round) {

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
    public void createHistories() {
        int g = 0;
        int r = 0;
        for (Player player : players) {
            History history = new History();
            history.setPlayer(player);
            history.setGroupp(groups.get(g%groupsCount));
            history.setRound(rounds.get(0));
            historyRepository.save(history);
            g++;
            r++;
        }
    }

    public void createGames() {
        rounds.forEach(this::createGames);
    }
}
