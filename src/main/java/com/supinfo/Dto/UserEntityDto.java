package com.supinfo.Dto;

import com.supinfo.DAO.UserEntityDAO;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named("user")
@Getter
@Setter
public class UserEntityDto implements Serializable {
    private String id;
    private String username;
    private String firstName;
    private String name;
    private String email;
    private String zipCode;
    private String password;
    private UserEntityDAO userEntityDAO = new UserEntityDAO();

    public UserEntityDto() {
    }

    public UserEntityDto(String username, String firstName, String name, String email, String zipCode, String password) {
        this.username = username;
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.password = password;
    }

    public UserEntityDto(String id, String username, String firstName, String name, String email, String zipCode, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.password = password;
    }

    public UserEntityDto(String username, String password) {
        this.username = username;
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
        return "UserEntityDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", password='" + password + '\'' +
                ", userEntityDAO=" + userEntityDAO +
                '}';
    }

    public boolean login() { return userEntityDAO.userLogin(this); }
    public boolean register() {
        return userEntityDAO.add(this);
    }
    public boolean edit() {
        return userEntityDAO.userEdit(this);
    }
}
