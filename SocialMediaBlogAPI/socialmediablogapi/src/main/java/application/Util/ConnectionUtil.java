package application.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static String url = "jdbc:mysql://localhost:3306/revature";
    private static String username = "revature";
    private static String password = "revature";

    private static Connection connection = null;

    /**
     * @return active connection to the database
     */

    public static Connection getConnection() {
        if (connection == null) {    
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection successful!");
                
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection failed!");
            }
        }        
        return connection;

    }
}
