package com.example.ClinicaOdontologica.dao.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class cfgJDBC {
    private String jdbcDriver;
    private String dbURL;
    private String userName;
    private String password;

    private static final String SQL_CREATING_TABLE_PATIENTS = "" +
            "DROP TABLE IF EXISTS PATIENTS;" +
            "CREATE TABLE PATIENTS" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "name VARCHAR(50)," +
            "surname VARCHAR(50)," +
            "email VARCHAR(50)," +
            "cpf VARCHAR(15)," +
            "register_date VARCHAR(30)," +
            "address_id int," +
            "FOREIGN KEY (address_id) REFERENCES ADDRESSES(id))";

    private static final String SQL_CREATING_TABLE_ADDRESSES = "" +
            "DROP TABLE IF EXISTS PATIENTS; " +
            "DROP TABLE IF EXISTS ADDRESSES; " +
            "CREATE TABLE ADDRESSES" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "street VARCHAR(250)," +
            "number int," +
            "city VARCHAR(50)," +
            "state VARCHAR(50));";

    private static final String SQL_CREATING_TABLE_DENTISTS = "" +
            "DROP TABLE IF EXISTS DENTISTS;" +
            "CREATE TABLE DENTISTS" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "name VARCHAR(50)," +
            "surname VARCHAR(50)" +
            "registration VARCHAR(50));";

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
        createTables();
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

    public void createTables() {
        try {
            Connection connection = database_connection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATING_TABLE_ADDRESSES);
            statement.execute(SQL_CREATING_TABLE_PATIENTS);
            statement.execute(SQL_CREATING_TABLE_DENTISTS);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
