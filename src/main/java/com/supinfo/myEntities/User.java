package com.supinfo.myEntities;

import com.supinfo.datasource.MyDataSource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@ManagedBean(name = "user")
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String Id;
    private String username;
    private String firstName;
    private String name;
    private String email;
    private String zipCode;
    private String password;
    private MyDataSource dataSource = new MyDataSource();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String firstName, String name, String email, String zipCode, String password) {
        this.username = username;
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.password = password;
    }

    public boolean login() {
        return dataSource.userLogin(this);
    }
    public boolean register() {
        return dataSource.userRegister(this);
    }

}
