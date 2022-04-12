package com.supinfo.Dto;

import com.supinfo.DAO.ObjectEntityDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class ObjectEntityDto implements Serializable {
    private String id;
    private String name;
    private String description;
    private String encode;
    private String price;
    private UserEntityDto user;
    private ObjectEntityDAO objectEntityDAO = new ObjectEntityDAO();

    public ObjectEntityDto(String name, String description, String price, UserEntityDto user)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectEntityDto entity = (ObjectEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "user = " + user + ")";
    }

    public boolean add(Part part) {
        return objectEntityDAO.addObject(this, part);
    }
}
