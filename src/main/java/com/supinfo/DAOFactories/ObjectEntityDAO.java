package com.supinfo.DAOFactories;

import com.supinfo.entities.ObjectEntity;
import com.supinfo.entities.ObjectEntityDto;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Stateless
public class ObjectEntityDAO extends Ems{

    public ObjectEntity findById(int id)
    {
        return em.find(ObjectEntity.class, id);
    }

    public List<ObjectEntity> getAll(){
        return em.createNamedQuery("Obj.findAll", ObjectEntity.class).getResultList();
    }

    public List<ObjectEntity> getByName(String name)
    {
        return em.createNamedQuery("Obj.findByName", ObjectEntity.class)
                .setParameter("name", "%"+name.toLowerCase(Locale.ROOT)+"%").getResultList();
    }

    public Collection<Object> serialObjectsEntities(@NotNull List<ObjectEntity> objectEntities)
    {
        Collection<Object> objects = new ArrayList<>();
        objectEntities.forEach(objectEntity -> {
            objects.add(new ObjectEntityDto(objectEntity));
        });
        return objects;
    }

}
