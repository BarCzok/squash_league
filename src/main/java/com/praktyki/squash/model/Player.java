package com.praktyki.squash.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int phoneNumber;
    private String adress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
    private List<History> histories;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}