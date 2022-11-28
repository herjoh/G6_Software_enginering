package com.example.g6brombrom.util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import javax.sql.DataSource;
import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest  {

    private DataSource dataSource;
    private static Connection conn = null;
    private  final String sateSourcePathing = "jdbc:sqlite:src/main/java/com/example/g6brombrom/DataBase/karsdb.db.db";

    @Test
    @DisplayName("Check and see if can connect to source db: ")
    void test_dbConnect_for_source() throws SQLException {
        try (Connection connection = DriverManager.getConnection(sateSourcePathing)) {
            String catalog = connection.getCatalog();
            assertEquals(catalog,true);
        }
    }

    @Test
    @DisplayName("Check and see if can connect to source db: ")
    void test_dbConnect_for_source_2() throws SQLException {
        try (Connection connection = DriverManager.getConnection(sateSourcePathing)) {
            String catalog = connection.getCatalog();
            assertThat(catalog).isNull();
        }
    }
    @Test
    @DisplayName("Check and see if can connect to source db: ")
    void test_dbConnect_for_source_3() throws SQLException {
        try (Connection connection = DriverManager.getConnection(sateSourcePathing)) {
            String catalog = connection.getCatalog();
            assertEquals(catalog,null);
        }
    }

    @Test
    @DisplayName("Check that query is executable: ")
    void dbExecuteQuery() {
        Statement stmt = null;
        ResultSet resultSet = null;
    }

    @Test
    @DisplayName("Check that table has data source: ")
    void test_db_for_dataSource() {
    }

    @Test
    public void test_tables_for_data_source() throws SQLException {

    }

    @Test
    void dbPreparedStatementUpdateInt() {
    }

    @Test
    void dbExecuteUpdate() {
    }
}