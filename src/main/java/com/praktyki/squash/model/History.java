package com.praktyki.squash.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {
     private int playerId;
     private int groupId;
//     private int roundId;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Groupss group;

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne
//    private Round roundId;


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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public int getRoundId() {
//        return roundId;
//    }
//
//    public void setRoundId(Round roundId) {
//        this.roundId = roundId;
//    }
//
//    public void setRoundId(int roundId) {
//        this.roundId = roundId;
//    }
}
