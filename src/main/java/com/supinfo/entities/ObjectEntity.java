package com.supinfo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "object", schema = "barter_trade")
@NamedQueries(value = {
        @NamedQuery(name = "Obj.findAll", query = "SELECT o from ObjectEntity o"),
        @NamedQuery(name = "Obj.findByNameDesPri", query = "SELECT o from ObjectEntity o where o.name LIKE :name " +
                "OR o.description LIKE :description OR o.price = :price group by o.id")
})
@Getter
@Setter
public class ObjectEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "image")
    private byte[] image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectEntity that = (ObjectEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
