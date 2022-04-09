package com.supinfo.myEntities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "object")
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class Object {
    private String name;
    private String description;
    private String price;

    public Object(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
