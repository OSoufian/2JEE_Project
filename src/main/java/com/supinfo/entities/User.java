package com.supinfo.entities;

import com.supinfo.datasource.MyDataSource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "user")
@RequestScoped
public class User {
    private String username;
    private String password;
    private MyDataSource datasource = new MyDataSource();

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

    public String login() {

        return datasource.userLogin(username, password);
    }
}
