package com.praktyki.squash.repository.custom.impl;

import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.model.TransitionRule;
import com.praktyki.squash.repository.custom.CustomGroupssRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


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

    @Override
    public List<TransitionRule> getTransitionRules(Groupss group) {
        Query query = entityManager.createQuery("select tr from TransitionRule as tr where tr.sourceGroup.id =:groupId");
        query.setParameter("groupId", group.getId());

        return query.getResultList();
    }


}
