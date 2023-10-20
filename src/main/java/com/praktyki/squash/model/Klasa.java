package com.praktyki.squash.model;

import javax.persistence.*;
@Entity
@Table(name = "klasa")
public class Klasa {

    @Id
    @GeneratedValue
    private int id;

    private String list;

    @OneToMany
    private Uczen uczen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setUczen(Uczen uczen) {
        this.uczen = uczen;
    }

    public String getList() {
        return list;
    }

    public Uczen getUczen() {
        return uczen;
    }




}
