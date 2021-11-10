package com.example.ClinicaOdontologica.dao.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cfgJDBC {
    private String jdbcDriver;
    private String dbURL;
    private String userName;
    private String password;

    private static final String SQL_CREATING_TABLE_PATIENTS = "" +
            "DROP TABLE IF EXISTS PATIENTS;" +
            "CREATE TABLE PATIENTS" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "";
    private static final String SQL_CREATING_TABLE_ADDRESSES = "";
    private static final String SQL_CREATING_TABLE_DENTISTS = "";

    public cfgJDBC(String jdbcDriver, String dbURL, String userName, String password) {
        this.jdbcDriver = jdbcDriver;
        this.dbURL = dbURL;
        this.userName = userName;
        this.password = password;
    }

    public cfgJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbURL = "jdbc:h2:~/test";
        this.userName = "sa";
        this.password = "";
    }

    public Connection database_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    dbURL,
                    userName,
                    password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
