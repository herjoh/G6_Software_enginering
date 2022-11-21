package Ny_GUI.Tools.Temp_dev_tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Direct_queries {

    public static String[] viewTable(String query,Connection con) throws SQLException {
        String[] output = new String[25];

        String query_ex = query;
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
