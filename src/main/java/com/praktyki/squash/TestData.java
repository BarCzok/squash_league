package com.praktyki.squash;

import com.praktyki.squash.model.*;
import com.praktyki.squash.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

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
            round.setEndDate("endingRound" + i);
            round.setStartDate("starRound" + i);
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

//    public void createGroupTransitions(Groupss sourceGroup, int roundId){
//        Map<Groupss, List<Player>> playersInGroups = playersRepository.getPlayersInGroups(roundId);
//
//        Map.Entry<Groupss, List<Player>> groupssListEntry = playersInGroups.entrySet().stream().filter(e -> e.getKey().getId() == sourceGroup.getId()).findFirst().get();
//
//        Groupss g = groupssListEntry.getKey();
//        int groupSize = groupssListEntry.getValue().size();
//
//        if(g.getName().equals("Grupa0")){
//            //first group
//            Map<Integer, Groupss> transitionRules = new HashMap<>();
//            transitionRules.put(1, sourceGroup);
//            transitionRules.put(2, sourceGroup);
//
//
//            sourceGroup.setTransitionRules(transitionRules);
//
//            groupsRepository.save(sourceGroup);
//        }
//        else if(g.getName().equals("Grupa"+(playersInGroups.size()-1))){
//            //last group
//        }
//        else {
//            //other groups
//        }
//
//
//    }

    public void getPlayersByPhoneNr(){
        Player byPhoneNumber1 = playersRepository.findByPhoneNumber(837349531);
    }

}

