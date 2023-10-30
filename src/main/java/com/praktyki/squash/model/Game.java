package com.praktyki.squash.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matches")
public class Game {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    private List<Score> scores;

    @ManyToOne
    private Round round;


    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
