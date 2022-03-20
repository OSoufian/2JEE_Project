package com.supinfo.entities;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ObjectEntity.class)
public abstract class ObjectEntity_ {

	public static volatile SingularAttribute<ObjectEntity, byte[]> image;
	public static volatile SingularAttribute<ObjectEntity, Integer> price;
	public static volatile SingularAttribute<ObjectEntity, String> name;
	public static volatile SingularAttribute<ObjectEntity, String> description;
	public static volatile SingularAttribute<ObjectEntity, Integer> id;

	public static final String IMAGE = "image";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

