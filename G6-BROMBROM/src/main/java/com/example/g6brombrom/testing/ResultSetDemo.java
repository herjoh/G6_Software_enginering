package com.example.g6brombrom.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ResultSetDemo {

    public static void main(String[] args) {
        String query = "select merke, modell, eier, årsmodell from cars";
        Connection conn = null;
        Statement stmt = null;
        try {
            String sqLite = "jdbc:sqlite:src/sample/DataBase/karsdb.db.db";
            conn = DriverManager.getConnection(sqLite);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String merke = rs.getString(1);
                String modell = rs.getString(2);
                String eier = rs.getString(3);
                Integer årsmodell = rs.getInt(4);
                System.out.println("merke:" + merke);
                System.out.println("modell:" + modell);
                System.out.println("eier:" + eier);
                System.out.println("årsmodell:" + årsmodell);
                System.out.println("");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {}
        }
    }
}
