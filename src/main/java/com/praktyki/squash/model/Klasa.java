package com.praktyki.squash.model;

import javax.persistence.*;
@Entity
@Table(name = "klasa")
public class Klasa {

    @Id
    @GeneratedValue
    private int id;

    private String list;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getList() {
        return list;
    }
}
