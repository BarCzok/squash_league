package com.praktyki.squash.facades.dto;

public class RoundDTO {
    int id;
    String name;

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

    @Override
    public String toString() {
        return "GroupssDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
