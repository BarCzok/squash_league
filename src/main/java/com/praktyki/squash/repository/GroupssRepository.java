package com.praktyki.squash.repository;

import com.praktyki.squash.model.Groupss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GroupssRepository extends CrudRepository<Groupss, Integer> {
}
