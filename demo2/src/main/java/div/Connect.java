package div;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    Connection conn;

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/Andre/IdeaProjects/demo2/src/main/karsdb.db.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Successful connection to database.");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }    
            }