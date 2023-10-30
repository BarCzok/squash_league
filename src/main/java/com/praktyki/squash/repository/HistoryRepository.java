package com.praktyki.squash.repository;

import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface HistoryRepository extends CrudRepository<History, Integer>{}
