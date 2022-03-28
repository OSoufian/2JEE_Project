package com.supinfo.entities;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class ObjectEntityDto implements Serializable {
    private final int id;
    private final String name;
    private final String description;
    private final int price;
    private final byte[] image;

    public ObjectEntityDto(ObjectEntity objectEntity)
    {
        this.id = objectEntity.getId();
        this.name = objectEntity.getName();
        this.description = objectEntity.getDescription();
        this.price = objectEntity.getPrice();
        this.image = objectEntity.getImage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectEntityDto entity = (ObjectEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.image, entity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, image);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "image = " + image + ")";
    }
}
