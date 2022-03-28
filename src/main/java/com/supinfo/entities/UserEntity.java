package com.supinfo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "barter_trade", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "zip_code")
    private String zipCode;
    @Basic
    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(zipCode, that.zipCode)) return false;
        if (!Objects.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
