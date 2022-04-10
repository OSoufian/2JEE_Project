package com.supinfo.datasource;

//import com.supinfo.entities.UserEntityDto;
import com.supinfo.myEntities.Object;
import com.supinfo.myEntities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
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

    public List<Object> getUserObjects(String userId) {
        Connection con = null;
        List<Object> userObjects = new ArrayList<>();

        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "SELECT * FROM object WHERE user_id = "
                            + userId;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    Object object;
                    while(rs.next()) {
                        object = new Object();
                        byte[] imgData = rs.getBytes("image");
                        String encode = Base64.getEncoder().encodeToString(imgData);
                        object.setName(rs.getString("name"));
                        object.setDescription(rs.getString("description"));
                        object.setPrice(rs.getString("price"));
                        object.setEncode(encode);
                        userObjects.add(object);
                    }

                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return userObjects;
    }

    public boolean userEdit(User user) {
        Connection con = null;
        PreparedStatement ps = null;
//        int i = 0;
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

    public boolean addObject(Object object, Part part) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        if (dataSource != null) {
            try {
                con = dataSource.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO object(user_id, name, description, price, image) VALUES(?,?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "1");
                    ps.setString(2, object.getName());
                    ps.setString(3, object.getDescription());
                    ps.setString(4, object.getPrice());
                    ps.setBlob(5, part.getInputStream());
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
}
