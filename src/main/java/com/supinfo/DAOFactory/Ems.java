package com.supinfo.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;

abstract class Ems {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public EntityManager em = emf.createEntityManager();
    public CriteriaBuilder cb = em.getCriteriaBuilder();
}
