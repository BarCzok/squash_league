package com.praktyki.squash.repository;
import com.praktyki.squash.model.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

    @Component
    public interface RoundRepository extends CrudRepository<Round, Integer> {
    }

