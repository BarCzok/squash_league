package com.praktyki.squash.model;


import javax.persistence.*;
@Entity
@Table(name = "uczen")
public class Uczen {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}