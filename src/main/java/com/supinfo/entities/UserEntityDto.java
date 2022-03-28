package com.supinfo.entities;

import com.supinfo.datasource.MyDataSource;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named("user")
@Getter
@Setter
public class UserEntityDto implements Serializable {
    private int id;
    private String username;
    private String firstName;
    private String name;
    private String email;
    private String zipCode;
    private String password;
    private MyDataSource dataSource = new MyDataSource();

    public UserEntityDto() {
    }

    public UserEntityDto(int id, String username, String firstName, String name, String email, String zipCode, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDto entity = (UserEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.zipCode, entity.zipCode) &&
                Objects.equals(this.password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, name, email, zipCode, password);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "firstName = " + firstName + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "zipCode = " + zipCode + ", " +
                "password = " + password + ")";
    }

//    public String login() {
//        return dataSource.userLogin(this);
//    }
//    public String register() {
//        return dataSource.userRegister(this);
//    }
}
