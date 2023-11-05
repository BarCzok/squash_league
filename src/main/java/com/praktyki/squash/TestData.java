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

    @Resource
    TransitionrulesRepository transitionrulesRepository;

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
            group.setGroupRank(i);
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

    public void createGroupTransitions(Groupss sourceGroup, int roundId){
        Map<Groupss, List<Player>> playersInGroups = playersRepository.getPlayersInGroups(roundId);

        Map.Entry<Groupss, List<Player>> groupssListEntry = playersInGroups.entrySet().stream().filter(e -> e.getKey().getId() == sourceGroup.getId()).findFirst().get();

        Groupss g = groupssListEntry.getKey();
        int groupSize = groupssListEntry.getValue().size();

        if(g.getName().equals("Grupa0")){
            //first group
            List<TransitionRule> trasitionRules = new ArrayList<>();

            for(int i=1; i<groupSize; i++) {
                TransitionRule transitionRule = new TransitionRule();
                transitionRule.setPosition(i);
                transitionRule.setTargetGroup(sourceGroup);
                transitionRule.setSourceGroup(sourceGroup);
                trasitionRules.add(transitionRule);
            }

            //last player degrades to lower group
            //TODO: create transition rule
//            Groupss lowerGroup = groupsRepository.getLowerGroup(sourceGroup);
//
//            TransitionRule transitionRuleLowerGroup = new TransitionRule();
//            transitionRuleLowerGroup.setPosition(groupSize);
//            transitionRuleLowerGroup.setTargetGroup(lowerGroup); //next group
//            transitionRuleLowerGroup.setSourceGroup(sourceGroup); //next group
//            trasitionRules.add(transitionRuleLowerGroup);

            transitionrulesRepository.saveAll(trasitionRules);
        }
        else if(g.getName().equals("Grupa"+(playersInGroups.size()-1))){
            //last group
            List<TransitionRule> trasitionRules = new ArrayList<>();

            //only first player advances to the higher group
            //TODO: create transition rule
//            Groupss higherGroup = groupsRepository.getHigherGroup(sourceGroup);
//
//            TransitionRule transitionRuleHigherGroup = new TransitionRule();
//            transitionRuleHigherGroup.setPosition(1);
//            transitionRuleHigherGroup.setTargetGroup(higherGroup); //next group
//            transitionRuleHigherGroup.setSourceGroup(sourceGroup); //next group
//            trasitionRules.add(transitionRuleHigherGroup);

            //players from rank > 2 stay in the same group
            for(int i=2; i<=groupSize; i++) {
                TransitionRule transitionRuleSameGroup = new TransitionRule();
                transitionRuleSameGroup.setPosition(i);
                transitionRuleSameGroup.setTargetGroup(sourceGroup); //next group
                transitionRuleSameGroup.setSourceGroup(sourceGroup); //next group
                trasitionRules.add(transitionRuleSameGroup);
            }

            transitionrulesRepository.saveAll(trasitionRules);
        }
        else {
            //other groups
            List<TransitionRule> trasitionRules = new ArrayList<>();

            //TODO: create transition rule
//            Groupss higherGroup = groupsRepository.getHigherGroup(sourceGroup);
//
//            TransitionRule transitionRuleHigherGroup = new TransitionRule();
//            transitionRuleHigherGroup.setPosition(1);
//            transitionRuleHigherGroup.setTargetGroup(higherGroup); //next group
//            transitionRuleHigherGroup.setSourceGroup(sourceGroup); //next group
//            trasitionRules.add(transitionRuleHigherGroup);

            //players from rank > 2 stay in the same group
            for(int i=2; i<groupSize; i++) {
                TransitionRule transitionRule = new TransitionRule();
                transitionRule.setPosition(i);
                transitionRule.setTargetGroup(sourceGroup); //next group
                transitionRule.setSourceGroup(sourceGroup); //next group
                trasitionRules.add(transitionRule);
            }

//            Groupss lowerGroup = groupsRepository.getLowerGroup(sourceGroup);
//
//            TransitionRule transitionRuleLowerGroup = new TransitionRule();
//            transitionRuleLowerGroup.setPosition(groupSize);
//            transitionRuleLowerGroup.setTargetGroup(lowerGroup); //next group
//            transitionRuleLowerGroup.setSourceGroup(sourceGroup); //next group
//            trasitionRules.add(transitionRuleLowerGroup);

            transitionrulesRepository.saveAll(trasitionRules);
        }


    }

    public void getPlayersByPhoneNr(){
        Player byPhoneNumber1 = playersRepository.findByPhoneNumber(837349531);
    }

}

