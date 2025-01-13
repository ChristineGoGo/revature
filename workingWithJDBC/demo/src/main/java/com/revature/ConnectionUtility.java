package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    static String url = "jdbc:mysql://localhost:3306/revature";
    static String username = "revature";
    static String password = "revature";

    static Connection getConnection() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (SQLException e) {
            System.out.println("Error loading the database!");
        }
        return connection;

    }

}
