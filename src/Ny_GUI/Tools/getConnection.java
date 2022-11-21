package Ny_GUI.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
    public static Connection conn = null;
    public static Connection connect(String url) {

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Kobling oprettet.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
   public static void closeConnection() throws SQLException {
        conn.close();

   }
}
