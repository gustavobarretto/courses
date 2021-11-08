package Class11;

import java.sql.*;

public class Main {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMAIS;" +
            "CREATE TABLE ANIMAIS(" +
            "ID INT PRIMARY KEY," +
            "NOME varchar(100) NOT NULL," +
            "TIPO varchar(100) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (1, 'Pancho', 'Cachorro')";
    private static final String SQL_INSERT2 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (2, 'Pillo', 'Gato')";
    private static final String SQL_INSERT3 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (3, 'Cepillo', 'Elefante')";
    private static final String SQL_INSERT4 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (4, 'Pepe', 'Cavalo')";
    private static final String SQL_INSERT5 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (5, 'Rolo', 'Bem-te-vi')";

    private static final String SQL_DELETE = "DELETE FROM ANIMAIS WHERE ID=4";

    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_INSERT);
            statement.execute(SQL_INSERT2);
            statement.execute(SQL_INSERT3);
            statement.execute(SQL_INSERT4);
            statement.execute(SQL_INSERT5);

            verAnimais(connection);

            statement.execute(SQL_DELETE);

            verAnimais(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();

        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    private static void verAnimais(Connection connection) throws SQLException {
        String sql = "SELECT * FROM ANIMAIS";
        Statement sqlSmt = connection.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }


}
