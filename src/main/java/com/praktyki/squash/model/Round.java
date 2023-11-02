package com.praktyki.squash.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name="Round")
public class Round {
    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", histories=" + histories +
                ", games=" + games +
                '}';
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String startDate;
    private String endDate;
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
