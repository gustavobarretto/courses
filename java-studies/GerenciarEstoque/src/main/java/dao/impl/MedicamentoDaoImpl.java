package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MedicamentoDaoImpl implements IDao<Medicamento> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(MedicamentoDaoImpl.class);

    public MedicamentoDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }


    @Override
    public Medicamento salvar(Medicamento medicamento) {
        log.debug("Registrando um novo medicamento: " + medicamento.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("INSERT INTO medicamentos(codigoNumerico,nome,laboratorio,quantidade,preco) VALUES('%s','%s','%s','%s','%s')",
                medicamento.getCodigoNumerico(), medicamento.getNome(),medicamento.getLaboratorio(),medicamento.getQuantidade(),medicamento.getPreco());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                medicamento.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar() {
        return null;
    }
}
