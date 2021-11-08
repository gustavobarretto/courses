package Class12_integrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class Main {

    /*
    Utilizaremos um statement para criar uma tabela de funcionários
    com cinco colunas. A única coluna obrigatória será a coluna ID,
    que também é Primary Key, e as demais colunas são de livre escolha.
    Em seguida:

    Devemos inserir três linhas com dados diferentes, e uma delas deve conter o ID repetido;

    Verificar se está ocorrendo o erro: “Unique index or primary key violation”,
    ocasionado ao tentar inserir dois registros com o mesmo ID. Então devemos tratá-lo
    como exceção, registar o erro em log e continuar com a execução das demais instruções;

    IMPLEMENTAÇÃO: INSERIR ERROR NO LOG.

    Em seguida, você deve atualizar um dos funcionários com um novo valor em uma de
    suas colunas e registrar com um objeto de depuração (debug) as informações do funcionário;

    Posteriormente, temos que excluir um funcionários de acordo com o ID e registrar
    as informações do funcionário excluído como um objeto de informação (info);

    EDU EXCLUÍDO PELAS PIADAS PÉSSIMAS

    Por último, excluir outro funcionário utilizando como critério outra coluna que
    não seja o ID, como por exemplo o e-mail, e registrar as informações do funcionário
    excluído como um objeto de informação (info).
    */

    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS FUNCIONARIO;" +
            "CREATE TABLE FUNCIONARIO(" +
            "ID INT PRIMARY KEY, " +
            "NOME varchar(100)," +
            "SOBRENOME varchar(100)," +
            "IDADE INT," +
            "FUNCAO varchar(100))"
            ;

    private static final String sqlInsert = "INSERT INTO FUNCIONARIO (ID, NOME, SOBRENOME, IDADE, FUNCAO) " +
            "VALUES" +
            "(1, 'Eduardo', 'Araújo', 37, 'Chefe')";
    private static final String sqlInsert2 = "INSERT INTO FUNCIONARIO (ID, NOME, SOBRENOME, IDADE, FUNCAO) " +
            "VALUES" +
            "(2, 'Giselle', 'Piasetzki', 21, 'Gerente Financeira')";
    private static final String sqlInsert3 = "INSERT INTO FUNCIONARIO (ID, NOME, SOBRENOME, IDADE, FUNCAO) " +
            "VALUES" +
            "(1, 'Marcelo', 'Nader', 23, 'Gerente Administrativo')";
    private static final String sqlInsert4 = "INSERT INTO FUNCIONARIO (ID, NOME, SOBRENOME, IDADE, FUNCAO) " +
            "VALUES" +
            "(3, 'Gustavo', 'Barretto', 18, 'Zelador')";

    private static final String sqlUpdate = "UPDATE FUNCIONARIO SET FUNCAO = 'Porteiro' WHERE ID=3";

    private static final String sqlDelete = "DELETE FROM FUNCIONARIO WHERE ID=1";
    private static final String sqlDelete2 = "DELETE FROM FUNCIONARIO WHERE NOME='Gustavo'";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            insertingData(CREATE_TABLE, statement, "Tabela criada");
            insertingData(sqlInsert, statement, "Funcionário criado");
            insertingData(sqlInsert2, statement, "Funcionário criado");
            insertingData(sqlInsert3, statement, "Funcionário criado");
            insertingData(sqlInsert4, statement, "Funcionário criado");
            insertingData(sqlUpdate, statement, "O funcionário Gustavo Barretto foi promovido de zelador para porteiro.");
            insertingData(sqlDelete, statement, "O funcionário Eduardo de Araújo foi dispensado de seus serviços de Chefe pelas suas piadas péssimas.");
            insertingData(sqlDelete2, statement, "O funcionário Gustavo foi dispensado de seus serviços porque se chama Gustavo e não tem senso de humor.");

        } catch (Exception e) {
            logger.error(e);
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

    private static void insertingData (String sqlCommand, Statement statement, String logInfo) {
        try {
            statement.execute(sqlCommand);
            logger.info(logInfo);
        } catch (Exception e) {
            logger.error("Unique index or primary key violation");
        }
    }

}
