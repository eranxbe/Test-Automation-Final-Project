package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps{
    
    public static void startConnection(String dbURL, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error while connecting to DB: " + e);
        }
    }

    public static void endConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error while closing connection to DB: " + e);
        }
    }
    
}
