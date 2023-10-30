package com.praktyki.squash.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue
    private int id;
    private int playerId;
     private int groupId;
     private int roundId;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Groupss group;



    @ManyToOne
    private Round round;


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Groupss getGroup() {
        return group;
    }

    public void setGroup(Groupss group) {
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRoundId() {
        return roundId;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }
}
