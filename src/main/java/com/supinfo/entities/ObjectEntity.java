package com.supinfo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "object", schema = "barter_trade")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({@NamedQuery(name = "ObjectEntity.findById",
        query = "SELECT p FROM ObjectEntity p WHERE p.id = :id"),
        @NamedQuery(name = "ObjectEntity.findByName",
                query = "SELECT p FROM ObjectEntity p WHERE p.name = :name"),
        @NamedQuery(name = "ObjectEntity.findByDescription",
                query = "SELECT p FROM ObjectEntity p WHERE p.description = :description"),
        @NamedQuery(name = "ObjectEntity.findAll",
                query = "SELECT p FROM ObjectEntity p")})
public class ObjectEntity implements Serializable {
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