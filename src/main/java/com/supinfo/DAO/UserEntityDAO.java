package com.supinfo.DAO;

import com.supinfo.Dto.ObjectEntityDto;
import com.supinfo.Dto.UserEntityDto;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Getter
@Setter
public class UserEntityDAO {
    private DAOConnect daoConnect;
    private String queryId;
    private String queryUsername;
    private String queryFirstName;
    private String queryName;
    private String queryEmail;
    private String queryZipCode;
    private String queryPassword;
    private DataSource dataSource;

    public UserEntityDAO() {
        try {
            Context contexte = new InitialContext();
            dataSource = (DataSource) contexte.lookup("java:/barter_trade");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public UserEntityDto getUserById(String id){
        Connection con = null;
        UserEntityDto user = new UserEntityDto();

        try {
            con = DAOConnect.getInstance();
            if (con != null) {
                String sql = "SELECT * FROM user WHERE id = " + id;
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setZipCode(rs.getString("zip_code"));
                    user.setUsername(rs.getString("username"));
                    user.setFirstName(rs.getString("first_name"));
                    ps.executeUpdate();
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return user;
    }


    public boolean add(UserEntityDto userEntityDto) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
                con = DAOConnect.getInstance();
                ps = con.prepareStatement("INSERT INTO user(username, first_name, name, email, zip_code, password) VALUES(?,?,?,?,?,?)");
                ps.setString(1, userEntityDto.getUsername());
                ps.setString(2, userEntityDto.getFirstName());
                ps.setString(3, userEntityDto.getName());
                ps.setString(4, userEntityDto.getEmail());
                ps.setString(5, userEntityDto.getZipCode());
                ps.setString(6, userEntityDto.getPassword());

                i = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        return i > 0;
    }

    public boolean userLogin(UserEntityDto user) {
        if (user.getUsername() != null) checkUserQuery(user.getUsername());
        if (user.getUsername().equals(queryUsername) && user.getPassword().equals(queryPassword)) {
            user.setId(queryId);
            user.setFirstName(queryFirstName);
            user.setName(queryName);
            user.setEmail(queryEmail);
            user.setZipCode(queryZipCode);
            return true;
        } else
            return false;
    }

    public void checkUserQuery(String username) {
        Connection con = null;

        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "SELECT * FROM user WHERE username = '"
                            + username + "'";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    queryId = rs.getString("id");
                    queryUsername = rs.getString("username");
                    queryFirstName = rs.getString("first_name");
                    queryName = rs.getString("name");
                    queryEmail = rs.getString("email");
                    queryZipCode = rs.getString("zip_code");
                    queryPassword = rs.getString("password");
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    public boolean userEdit(UserEntityDto user) {
        Connection con = null;
        PreparedStatement ps = null;
        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "UPDATE user SET username = ?, first_name = ?, name = ?, email = ?, zip_code = ? WHERE id = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user.getUsername());
                    ps.setString(2, user.getFirstName());
                    ps.setString(3, user.getName());
                    ps.setString(4, user.getEmail());
                    ps.setString(5, user.getZipCode());
                    ps.setString(6, user.getId());
                    ps.executeUpdate();
                    ps.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return true;
    }
}