package com.praktyki.squash.facades.dto;

public class ScoreDTO {
    int sets;
    int points;
    int pointsForWinning;
    int pointsForPlaying;
    PlayerDTO player;

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointsForWinning() {
        return pointsForWinning;
    }

    public void setPointsForWinning(int pointsForWinning) {
        this.pointsForWinning = pointsForWinning;
    }

    public int getPointsForPlaying() {
        return pointsForPlaying;
    }

    public void setPointsForPlaying(int pointsForPlaying) {
        this.pointsForPlaying = pointsForPlaying;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "sets=" + sets +
                ", points=" + points +
                ", pointsForWinning=" + pointsForWinning +
                ", pointsForPlaying=" + pointsForPlaying +
                ", player=" + player +
                '}';
    }
}
