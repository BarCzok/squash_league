package com.praktyki.squash.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "klasa")
public class Klasa {

    @Id
    @GeneratedValue
    private int id;
    private int nrSali;

    @OneToMany
    private List<Uczen> uczniowie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
