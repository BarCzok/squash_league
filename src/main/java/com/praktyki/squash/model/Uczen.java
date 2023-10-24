package com.praktyki.squash.model;


import javax.persistence.*;
@Entity
@Table(name = "uczen")
public class Uczen {

    @Id
    @GeneratedValue
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    @ManyToOne
    private Klasa klasa;

}