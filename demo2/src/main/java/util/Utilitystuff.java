package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Utilitystuff {

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
}


            /* public static void abcd(Connection conn) throws SQLException {

        final int TIMEOUT_DEFAULT = 30;
        String query = "select * from cars";
        ResultSet rs;
        Statement statement;
        List<String[]> cars;

        try {
            Statement st = conn.createStatement();
            statement.setQueryTimeout(TIMEOUT_DEFAULT);
            conn.setAutoCommit(true);
            rs = statement.executeQuery(query);


            try {
                cars = new ArrayList<>();
                while (rs.next()) {
                    cars.add(new String[]{
                            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)
                    });

                }*/






