package com.praktyki.squash.facades.dto;

public class PlayerDTO {
    int id;
    int placeInGroup;
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

    public int getPlaceInGroup() {
        return placeInGroup;
    }

    public void setPlaceInGroup(int placeInGroup) {
        this.placeInGroup = placeInGroup;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", placeInGroup=" + placeInGroup +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adress='" + adress + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
