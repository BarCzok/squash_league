package com.praktyki.squash.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name="Round")
public class Round {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "round")
    private List<History> histories;

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
