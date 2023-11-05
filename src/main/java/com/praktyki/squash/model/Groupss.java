package com.praktyki.squash.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;


@Entity
    @Table(name = "groupss")
    public class Groupss {
    @Id
    @GeneratedValue
    private int id;
    private int groupRank;

    private String name;

    @Cascade(ALL)
    @OneToMany(mappedBy = "sourceGroup")
    private List<TransitionRule> transitionRules;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "groupp")
    private List<History> history;

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

    public int getGroupRank() {
        return groupRank;
    }

    public void setGroupRank(int groupRank) {
        this.groupRank = groupRank;
    }

    public List<TransitionRule> getTransitionRules() {
        return transitionRules;
    }

    public void setTransitionRules(List<TransitionRule> transitionRules) {
        this.transitionRules = transitionRules;
    }
}

