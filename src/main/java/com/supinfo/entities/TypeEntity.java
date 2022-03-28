package com.supinfo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type", schema = "barter_trade")
@NamedQueries({
        @NamedQuery(name = "type.findAll", query = "SELECT o from TypeEntity o"),
        @NamedQuery(name = "type.findByName", query = "SELECT o from TypeEntity o where o.name LIKE :name")
})
@Getter
@Setter
public class TypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
