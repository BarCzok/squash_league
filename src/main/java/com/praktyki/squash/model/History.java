package com.praktyki.squash.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Groupss groupp;

    @ManyToOne
    private Round round;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Groupss getGroupp() {
        return groupp;
    }

    public void setGroupp(Groupss group) {
        this.groupp = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

}
