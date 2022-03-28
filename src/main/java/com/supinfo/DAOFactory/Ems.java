package com.supinfo.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

abstract class Ems {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public javax.persistence.EntityManager em = emf.createEntityManager();
}
