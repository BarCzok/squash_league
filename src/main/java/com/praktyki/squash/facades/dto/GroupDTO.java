package com.praktyki.squash.facades.dto;

public class GroupDTO implements Comparable {

    int id;
    String name;
    private int groupRank;

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

    public int getGroupRank() {
        return groupRank;
    }

    public void setGroupRank(int groupRank) {
        this.groupRank = groupRank;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupRank=" + groupRank +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        GroupDTO other = (GroupDTO) o;
        return this.id - other.id;
    }
}

