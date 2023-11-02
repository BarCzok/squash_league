package com.praktyki.squash.facades.dto;

public class PlayerDTO {
    int id;
    String name;
    int phoneNumber;
    String adress;
    private int totalPoints;

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

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adress='" + adress + '\'' +
                '}';
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
