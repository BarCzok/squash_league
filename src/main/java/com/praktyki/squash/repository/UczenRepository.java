package com.praktyki.squash.repository;

import com.praktyki.squash.model.Uczen;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;

@Resource(name = "uczenRepository")
public interface UczenRepository extends CrudRepository<Uczen, Integer> {

}
