package com.supinfo.DAOFactories;

import com.supinfo.entities.TypeEntity;
import com.supinfo.entities.TypeEntityDto;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Stateless
public class TypeEntityDAO extends Ems{

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

    public Collection<Object> serialTypesEntities(@NotNull List<TypeEntity> typeEntities)
    {
        Collection<Object> objects = new ArrayList<>();
        typeEntities.forEach(typeEntity -> {
            objects.add(new TypeEntityDto(typeEntity));
        });
        return objects;
    }
}
