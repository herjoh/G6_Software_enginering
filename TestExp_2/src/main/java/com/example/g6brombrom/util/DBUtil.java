package com.example.g6brombrom.util;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * Created by ONUR BASKIRT on 22.02.2016.
 */
public class DBUtil {
    //Declare JDBC Driver


    //Connection
    private static Connection conn = null;


    private static final String connStr = "jdbc:sqlite:src/main/java/com/example/g6brombrom/DataBase/karsdb.db.db";


    //Connect to DB
    public static void dbConnect() throws SQLException {
        //Setting Oracle JDBC Driver

        //Establish the Oracle Connection using Connection String
        try {
            conn = DriverManager.getConnection(connStr);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }


    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet crs = factory.createCachedRowSet();
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create statement
            stmt = conn.createStatement();

            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);

            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }

    public static void dbPreparedStatementUpdateString(String query,String regnr,String endring) throws SQLException {
        try {
            dbConnect();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,endring);
            stmt.setString(2,regnr);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        }
        dbDisconnect();
    }

    public static void dbPreparedStatementUpdateInt(String query,String regnr,int endring) throws SQLException {
        try {
            dbConnect();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,endring);
            stmt.setString(2,regnr);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        }
        dbDisconnect();
    }

    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }
}