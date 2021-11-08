package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jbdcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS " +
            "(" +
            "id int auto_increment primary key, " +
            "codigoNumerico int, " +
            "nome varchar(255), " +
            "laboratorio varchar(255), " +
            "quantidade int, " +
            "preco double)";

    public ConfiguracaoJDBC(String jbdcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jbdcDriver = jbdcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        criarTabela();
    }

    public ConfiguracaoJDBC() {
        this.jbdcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";
        criarTabela();
    }

    private void criarTabela() {
        try {
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection conectarBanco() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
