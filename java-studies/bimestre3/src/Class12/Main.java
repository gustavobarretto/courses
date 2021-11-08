package Class12;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS USUARIO;" +
            "CREATE TABLE USUARIO(" +
            "ID INT PRIMARY KEY, " +
            "PRIMEIRO_NOME varchar(100) NOT NULL," +
            "SOBRENOME varchar(100) NOT NULL, " +
            "IDADE INT NOT NULL)"
            ;

    private static final String sqlInsert = "INSERT INTO USUARIO (ID, PRIMEIRO_NOME, SOBRENOME, IDADE) " +
            "VALUES" +
            "(1, 'Maria', 'Aparecida', 50)";
    private static final String sqlInsert2 = "INSERT INTO USUARIO (ID, PRIMEIRO_NOME, SOBRENOME, IDADE) " +
            "VALUES" +
            "(2, 'Zé', 'Maria', 43)";
    private static final String sqlInsert3 = "INSERT INTO USUARIO (ID, PRIMEIRO_NOME, SOBRENOME, IDADE) " +
            "VALUES" +
            "(3, 'Tririca', 'Gonçalves', 65)";

    private static final String sqlDelete = "DELETE FROM USUARIO WHERE ID=2";

    private static final Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(CREATE_TABLE);

            logger.info("Tabela criada.");

            statement.execute(sqlInsert);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);

            statement.execute(sqlDelete);

            logger.info("Excluído o usuário com o ID 2");

        } catch (Exception e) {

        } finally {
            if(connection == null)
                return;
            connection.close();
        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

}
