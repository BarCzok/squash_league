package com.praktyki.squash.model;

import com.praktyki.squash.dto.PlayerDTO;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue
    private int id;
    private int sets;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Player player;

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
