package com.supinfo;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Named("helloServlet")
@SessionScoped
public class HelloServlet implements Serializable {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "PersistenceUnit")
    EntityManager entityManager;

}
