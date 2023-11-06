package com.praktyki.squash.repository.custom;

import com.praktyki.squash.model.Groupss;

public interface CustomGroupssRepository {
    Groupss getHigherGroup(Groupss sourceGroup);
    Groupss getLowerGroup(Groupss sourceGroup);

}
