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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    @ManyToOne
    private Klasa klasa;


}