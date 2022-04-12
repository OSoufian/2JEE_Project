package com.supinfo.DAO;

import com.supinfo.entities.TypeEntity;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Stateless
public class TypeEntityDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public EntityManager em = emf.createEntityManager();

    public TypeEntity findById(int id){
        return em.find(TypeEntity.class, id);
    }

    public List<TypeEntity> getAll(){
        return em.createNamedQuery("type.findAll", TypeEntity.class).getResultList();
    }

    public Collection<TypeEntity> getByName(String name){
        return em.createNamedQuery("type.findByName", TypeEntity.class)
                .setParameter("name", "%"+name.toLowerCase(Locale.ROOT)+"%").getResultList();
    }
}
