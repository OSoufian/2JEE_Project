package com.supinfo.entities;

import java.io.Serializable;
import java.util.Objects;

public class TypeEntityDto implements Serializable {
    private final int id;
    private final String name;

    public TypeEntityDto(TypeEntity typeEntity) {
        this.id = typeEntity.getId();
        this.name = typeEntity.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntityDto entity = (TypeEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}
