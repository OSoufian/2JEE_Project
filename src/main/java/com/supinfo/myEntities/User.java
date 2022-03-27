package com.supinfo.myEntities;

import com.supinfo.datasource.MyDataSource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@ManagedBean(name = "user")
@RequestScoped
public class User {
    private String username;
    private String firstName;
    private String name;
    private String email;
    private String zipCode;
    private String password;
    private MyDataSource dataSource = new MyDataSource();

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String login() {
        return dataSource.userLogin(this);
    }
    public String register() {
        return dataSource.userRegister(this);
    }

}
