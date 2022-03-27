package com.supinfo.datasource;

import com.supinfo.myEntities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class MyDataSource {
    private String queryName;
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
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public DataSource getDs() {
        return dataSource;
    }

    public void setDs(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String userLogin(User user) {
        if (user.getUsername() != null) checkUserQuery(user.getUsername());
        if (user.getUsername().equals(queryName) && user.getPassword().equals(queryPassword))
            return "success";
        else
            return "invalid";
    }

    public void checkUserQuery(String username) {
        Connection con = null;

        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "SELECT username, password FROM user WHERE username = '"
                            + username + "'";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    queryName = rs.getString("username");
                    queryPassword = rs.getString("password");
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    public String userRegister(User user) {
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
            return "success";
        else
            return "failure";

    }
}
