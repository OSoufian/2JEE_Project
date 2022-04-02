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
    private String username;
    private String firstName;
    private String name;
    private String email;
    private String zipCode;
    private String password;
    private MyDataSource dataSource = new MyDataSource();

//    public String login() {
//        return dataSource.userLogin(this);
//    }
    public String register() {
        return dataSource.userRegister(this);
    }

}
