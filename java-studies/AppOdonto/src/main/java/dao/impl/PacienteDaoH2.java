package dao.impl;

import dao.IDao;
import dao.configuration.ConfigJDBC;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao<Paciente> {

    Logger log = Logger.getLogger(PacienteDaoH2.class);
    private ConfigJDBC configJDBC;


    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("INSERT INTO paciente (nome) VALUES ('%s')",
                paciente.getNome());

        try {
            log.debug("Iniciando conexão com o banco - Paciente");
            log.info("Iniciando conexão com o banco - Paciente");
            statement = conexao.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));
            statement.close();
            conexao.close();
            } catch (SQLException e) {
            log.error("Erro de banco de dados");
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public void atualizar(Paciente paciente) {

    }
}
