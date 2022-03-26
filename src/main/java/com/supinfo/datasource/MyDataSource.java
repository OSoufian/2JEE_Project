package com.supinfo.datasource;

import com.supinfo.entities.User;

import javax.sql.DataSource;
import java.sql.*;

public class MyDataSource {
    private String dbPassword;
    private String dbName;
    private DataSource ds;

    public MyDataSource() {}

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public String userLogin(String username, String password) {
        if (username != null) checkUserQuery(username);
        if (username.equals(dbName) && password.equals(dbPassword))
            return "success";
        else
            return "invalid";
    }

    public void checkUserQuery(String username) {
        Connection con = null;

        if (ds != null) {
            try {
                con = ds.getConnection();
                if (con != null) {
                    String sql = "select username, password from user where username = '"
                            + username + "'";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    dbName = rs.getString("firstname");
                    dbPassword = rs.getString("password");
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
