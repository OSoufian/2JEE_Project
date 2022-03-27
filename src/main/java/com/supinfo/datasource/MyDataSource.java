package com.supinfo.datasource;

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

    public String userLogin(String username, String password) {
        if (username != null) checkUserQuery(username);
        if (username.equals(queryName) && password.equals(queryPassword))
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
}
