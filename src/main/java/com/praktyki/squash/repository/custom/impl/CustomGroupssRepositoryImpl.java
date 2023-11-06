package com.praktyki.squash.repository.custom.impl;

import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.repository.custom.CustomGroupssRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Component
public class CustomGroupssRepositoryImpl implements CustomGroupssRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Groupss getHigherGroup(Groupss sourceGroup){
        Query query = entityManager.createQuery("select g from Groupss as g where g.groupRank= :groupRank");
        query.setParameter("groupRank", sourceGroup.getGroupRank()-1);

        return (Groupss) query.getSingleResult();
    }
    public Groupss getLowerGroup(Groupss sourceGroup){
        Query query = entityManager.createQuery("select g from Groupss as g where g.groupRank =:groupRank");
        query.setParameter("groupRank", sourceGroup.getGroupRank()+1);

        return (Groupss) query.getSingleResult();
    }


}
