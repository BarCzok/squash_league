package com.praktyki.squash.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
    @Table(name = "groupss")
    public class Groupss {
        @Id
        @GeneratedValue
        private int id;

        private String name;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "groupp")
    private List<History> history;

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

        public void add(Groupss groupss) {
        }
    }

