package com.example.ClinicaOdontologica.dao.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cfgJDBC {
    private String jdbcDriver;
    private String dbURL;
    private String userName;
    private String password;

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
