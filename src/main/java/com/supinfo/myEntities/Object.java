package com.supinfo.myEntities;

import com.supinfo.datasource.MyDataSource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

@ManagedBean(name = "object")
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class Object {
    private String name;
    private String description;
    private String price;
    private String encode;
    private MyDataSource dataSource = new MyDataSource();

    public Object(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public boolean add(Part part) {
        return dataSource.addObject(this, part);
    }
}
