package sample.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class RS_AllColumnNames {
    private static Connection conn = null;


    public static void main(String args[]) throws Exception {
        //Registering the Driver
        //Registering the Driver

        //Getting the connection
        String sqLite = "jdbc:sqlite:src/sample/DataBase/karsdb.db.db";
        conn = DriverManager.getConnection(sqLite);
        System.out.println("Connection established......");
        //Creating a Statement object
        Statement stmt = conn.createStatement();
        //Retrieving the data
        ResultSet rs = stmt.executeQuery("select * from cars");
        //Retrieving the ResultSetMetadata object
        ResultSetMetaData rsMetaData = rs.getMetaData();
        System.out.println("List of column names in the current table: ");
        //Retrieving the list of column names
        int count = rsMetaData.getColumnCount();
        for (int i = 1; i <= count; i++) {
            System.out.println(rsMetaData.getColumnName(i));
        }
    }
}