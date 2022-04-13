package com.supinfo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnect {
    private static String url = "jdbc:mysql://localhost:3306/barter_trade";
    private static String username = "root";
    private static String password = "";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}