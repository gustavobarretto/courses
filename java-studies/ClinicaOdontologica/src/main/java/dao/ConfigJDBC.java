package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfigJDBC {
    private String jbdcDriver;
    private String DB_URL;
    private String userName;
    private String password;

    private static final String SQL_CREATE_TABLE_PATIENTS = "" +
            "DROP TABLE IF EXISTS PATIENTS;" +
            "CREATE TABLE PATIENTS" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "name VARCHAR(250)," +
            "last_name VARCHAR(250)," +
            "rg VARCHAR(20)," +
            "registered_date VARCHAR(20)," +
            "address_id int," +
            "FOREIGN KEY(address_id) REFERENCES ADDRESSES(id));";

    private static final String SQL_CREATE_TABLE_ADDRESSES = "" +
            "DROP TABLE IF EXISTS PATIENTS; " +
            "DROP TABLE IF EXISTS ADDRESSES; " +
            "CREATE TABLE ADDRESSES" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "street VARCHAR(250)," +
            "number int," +
            "city VARCHAR(50)," +
            "state VARCHAR(50));";

    private static final String SQL_CREATE_TABLE_DENTISTS = "" +
            "DROP TABLE IF EXISTS DENTISTS;" +
            "CREATE TABLE DENTISTS" +
            "(id int AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            "registration VARCHAR(20)," +
            "name VARCHAR(250)," +
            "lastname VARCHAR(250));";

    public ConfigJDBC() {
        this.jbdcDriver = "org.h2.Driver";
        this.DB_URL = "jdbc:h2:~/test";
        this.userName = "sa";
        this.password = "";
        createTables();

    }

    private void createTables() {
        try {
          Connection connection = connectionDB();
          Statement statement = connection.createStatement();
          statement.execute(SQL_CREATE_TABLE_ADDRESSES);
          statement.execute(SQL_CREATE_TABLE_PATIENTS);
          statement.execute(SQL_CREATE_TABLE_DENTISTS);
          connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection connectionDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
