package com.supinfo.datasource;

//import com.supinfo.entities.UserEntityDto;
import com.supinfo.myEntities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDataSource {
    private String queryId;
    private String queryUsername;
    private String queryFirstName;
    private String queryName;
    private String queryEmail;
    private String queryZipCode;
    private String queryPassword;
    private DataSource dataSource;

    public MyDataSource() {
        try {
            Context contexte = new InitialContext();
            dataSource = (DataSource) contexte.lookup("java:/barter_trade");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public String getQueryPassword() {
        return queryPassword;
    }

    public void setQueryPassword(String queryPassword) {
        this.queryPassword = queryPassword;
    }

    public String getQueryName() {
        return queryUsername;
    }

    public void setQueryName(String queryUsername) {
        this.queryUsername = queryUsername;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean userLogin(User user) {
        if (user.getUsername() != null) checkUserQuery(user.getUsername());
        if (user.getUsername().equals(queryUsername) && user.getPassword().equals(queryPassword)) {
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

    public boolean userRegister(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO user(username, first_name, name, email, zip_code, password) VALUES(?,?,?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user.getUsername());
                    ps.setString(2, user.getFirstName());
                    ps.setString(3, user.getName());
                    ps.setString(4, user.getEmail());
                    ps.setString(5, user.getZipCode());
                    ps.setString(6, user.getPassword());
                    i = ps.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (i > 0)
            return true;
        else
            return false;

    }

    public List<User> getUserList() {
        Connection con = null;
        List<User> userList = new ArrayList<>();

        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "SELECT * FROM user";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    User user;
                    while(rs.next()) {
                        user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setFirstName(rs.getString("first_name"));
                        userList.add(user);
                    }

                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return userList;
    }
}
