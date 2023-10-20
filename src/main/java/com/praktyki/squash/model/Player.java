package com.praktyki.squash.model;

import javax.persistence.*;

@Entity
@Table(name = "zawodnicy")
public class Player {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private Group group;

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
}