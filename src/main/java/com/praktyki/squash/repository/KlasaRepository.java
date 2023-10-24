package com.praktyki.squash.repository;


import com.praktyki.squash.model.Klasa;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;

@Resource(name = "klasaRepository")
public interface KlasaRepository extends CrudRepository<Klasa, Integer> {

}

