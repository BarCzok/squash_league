package com.praktyki.squash.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name="Round")
public class Round {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "round")
    private List<History> histories;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "round")
    private List<Game> games;

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
