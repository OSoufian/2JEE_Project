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
    private String id;
    private String name;
    private String description;
    private String price;
    private String encode;
    private User user;
    private MyDataSource dataSource = new MyDataSource();

    public Object(String name, String description, String price, User user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public boolean add(Part part) {
        return dataSource.addObject(this, part);
    }


}
