package com.praktyki.squash.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "grupy")
public class Group {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany
    private Set<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
