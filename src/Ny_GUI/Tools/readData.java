package Ny_GUI.Tools;

import java.sql.*;

public class readData {
    public static String[] viewTable(Connection con) throws SQLException {
        String[] output = new String[25];

        String query = "select * from sqlite_master";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int x = 0;
            while (rs.next()) {
                output[x] = rs.getString("type");
                x++;
                output[x] = rs.getString("name");
                x++;
                output[x] = rs.getString("tbl_name");
                x++;
                int rootpage = rs.getInt("rootpage");
                output[x] = Integer.toString(rootpage);
                x++;
                output[x] = rs.getString("sql");
                x++;
        }
        return output;

        }
    }
}