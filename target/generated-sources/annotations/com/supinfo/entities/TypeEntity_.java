package com.supinfo.entities;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypeEntity.class)
public abstract class TypeEntity_ {

	public static volatile SingularAttribute<TypeEntity, String> name;
	public static volatile SingularAttribute<TypeEntity, Integer> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

