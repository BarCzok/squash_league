package com.praktyki.squash.repository.custom;

import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.TransitionRule;

import java.util.List;

public interface CustomGroupssRepository {
    Groupss getHigherGroup(Groupss sourceGroup);
    Groupss getLowerGroup(Groupss sourceGroup);
    List<TransitionRule> getTransitionRules(Groupss group);
}
