package hotel.management.system;

import java.sql.Connection;
import java.sql.*;

public class Conn {
    Connection c;  // for connections
    Statement s;  // for statement

    // 5 steps for JDBC Connectivity
    Conn() {
        // 1) Register of drivers
        try { // for catching error
            // EXECUTION OF DRIVERS
            Class.forName("com.mysql.cj.jdbc.Driver");
            // CREATING THE CONNECTION STRING
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "8NXE9P8k"); // sql username & password
            // default port is 3306

            // CREATING THE STATEMENT- with statement we can execute mysql queries
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
