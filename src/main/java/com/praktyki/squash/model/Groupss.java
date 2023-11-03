package com.praktyki.squash.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


@Entity
    @Table(name = "groupss")
    public class Groupss {
    @Id
    @GeneratedValue
    private int id;
    private int groupRank;

    public int getGroupRank() {
        return groupRank;
    }

    public void setGroupRank(int groupRank) {
        this.groupRank = groupRank;
    }

    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "order_item_mapping",
//            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")})
//    @MapKey(name = "id")
//    private Map<Integer, Groupss> transitionRules;

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

    public void add(Groupss groupss) {
    }
}

