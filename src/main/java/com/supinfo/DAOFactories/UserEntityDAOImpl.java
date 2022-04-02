package com.supinfo.DAOFactories;

import com.supinfo.entities.UserEntityDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserEntityDAOImpl implements UserEntityDAO {
    private DAOFactory daoFactory;

    UserEntityDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(UserEntityDto userEntityDto) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = daoFactory.getConnection();
            ps = con.prepareStatement("INSERT INTO user(username, first_name, name, email, zip_code, password) VALUES(?,?,?,?,?,?)");
            ps.setString(1, userEntityDto.getUsername());
            ps.setString(2, userEntityDto.getFirstName());
            ps.setString(3, userEntityDto.getName());
            ps.setString(4, userEntityDto.getEmail());
            ps.setString(5, userEntityDto.getZipCode());
            ps.setString(6, userEntityDto.getPassword());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<UserEntityDto> lister() {
        List<UserEntityDto> userEntityDto = new ArrayList<UserEntityDto>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT username, first_name, name, email, zip_code, password FROM user;");

            while (resultat.next()) {
                String username = resultat.getString("username");
                String firstName = resultat.getString("first_name");
                String name = resultat.getString("name");
                String email = resultat.getString("email");
                String zipCode = resultat.getString("zip_code");
                String password = resultat.getString("password");

                UserEntityDto user = new UserEntityDto();
                user.setName(username);
                user.setFirstName(firstName);
                user.setName(name);
                user.setName(email);
                user.setName(zipCode);
                user.setName(password);

                userEntityDto.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntityDto;
    }

}