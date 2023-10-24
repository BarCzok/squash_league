package com.praktyki.squash.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "klasa")
public class Klasa {

    @Id
    @GeneratedValue
    private int id;
    private int nrSali;

    @OneToMany(mappedBy = "klasa")
    private List<Uczen> uczniowie;

    public int getId() {
        return id;
    }

    public int getNrSali() {
        return nrSali;
    }

    public void setNrSali(int nrSali) {
        this.nrSali = nrSali;
    }

    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setId(int id) {
        this.id = id;
    }

}
