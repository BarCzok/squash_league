package com.praktyki.squash.model;


import javax.persistence.*;
import java.util.Set;
import javax.persistence.Entity;

@Entity
@Table(name ="historia")
public class History {

    @ManyToOne
    private Player player;

    @ManyToOne
    private Group group;

    @ManyToOne
    private Round round;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Group getGroup() {
        return group;
    }

    public Round getRound() {
        return round;
    }
}
