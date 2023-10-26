package com.praktyki.squash.facades.dto;

import java.util.List;

public class GameDTO {
    int id;

    PlayerDTO player1;
    PlayerDTO player2;

    List<ScoreDTO> scores;

    List<ScoreDTO> pointsForWining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerDTO getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerDTO player1) {
        this.player1 = player1;
    }

    public PlayerDTO getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerDTO player2) {
        this.player2 = player2;
    }

    public List<ScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<ScoreDTO> scores) {
        this.scores = scores;
    }


    @Override
    public String toString() {
        return "GameDTO{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", score=" + scores +
                '}';
    }
}
