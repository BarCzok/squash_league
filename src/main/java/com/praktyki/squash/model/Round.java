package com.praktyki.squash.model;


import javax.persistence.*;


@Entity
@Table(name = "rundy")

public class Round {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany
    private History history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
