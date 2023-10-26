package com.praktyki.squash.facades.dto;

public class ScoreDTO {
    int sets;
    int pointsForSets;
    int pointsForWinning;
    int pointsForPlaying;
    int totalPoints;

    public int getTotalPoints() {
        return totalPoints;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "sets=" + sets +
                ", pointsForSets=" + pointsForSets +
                ", pointsForWinning=" + pointsForWinning +
                ", pointsForPlaying=" + pointsForPlaying +
                ", totalPoints=" + totalPoints +
                ", player=" + player +
                '}';
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    PlayerDTO player;

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getPointsForSets() {
        return pointsForSets;
    }

    public void setPointsForSets(int pointsForSets) {
        this.pointsForSets = pointsForSets;
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

}
