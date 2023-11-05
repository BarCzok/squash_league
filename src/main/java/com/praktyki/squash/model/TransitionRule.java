package com.praktyki.squash.model;

import javax.persistence.*;

@Entity
@Table(name = "transition_rules")
public class TransitionRule {
    @Id
    @GeneratedValue
    private Long id;

    private int position;

    @ManyToOne
    private Groupss sourceGroup;

    @OneToOne
    private Groupss targetGroup;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Groupss getSourceGroup() {
        return sourceGroup;
    }

    public void setSourceGroup(Groupss groupp) {
        this.sourceGroup = groupp;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int rank) {
        this.position = rank;
    }

    public Groupss getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(Groupss targetGroup) {
        this.targetGroup = targetGroup;
    }
}
