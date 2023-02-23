
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Skander
 */
public class MyDB {

    String url = "jdbc:mysql://localhost:3306/tunibus";
    String username = "root";
    String password = "";

    Connection cnx;
    
    
    private static MyDB instance;

    private MyDB() {
        try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static MyDB getInstance() {
        if (instance == null) {
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    
    
    
    
}
