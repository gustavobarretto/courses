package dao.impl;

import com.sun.jdi.event.StepEvent;
import dao.ConfigJDBC;
import dao.IDao;
import model.Address;
import org.apache.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import java.io.ObjectInputFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements IDao<Address> {

    private ConfigJDBC CFG_JBDC;
    final static Logger log = Logger.getLogger(AddressDaoImpl.class);

    public AddressDaoImpl() {
        this.CFG_JBDC = new ConfigJDBC();
    }

    @Override
    public Address save(Address address) {
        log.debug("Salvando novo endereço de id: " + address.toString());
        Connection connection = CFG_JBDC.connectionDB();
        Statement statement = null;
        String query = String.format("" +
                "INSERT INTO ADDRESSES (street, number, city, state)" +
                "VALUES('%s', '%s', '%s', '%s')", address.getStreet(),
                address.getNumber(), address.getCity(), address.getState()
        );

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                address.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public Address search(Integer id) {
        log.debug("Realizando busca de endereço de id: " +  id);
        Connection connection = CFG_JBDC.connectionDB();
        Statement statement = null;
        String query = String.format("" +
                "SELECT * FROM ADDRESSES WHERE id=%s", id);
        Address address = null;
        try {
            statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(query);
            if(rs.next()) {
                address = new Address(
                    rs.getInt("id"),
                    rs.getString("street"),
                    rs.getInt("number"),
                    rs.getString("city"),
                    rs.getString("state")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;

    }

    @Override
    public List<Address> searchAll() {
        Connection connection = CFG_JBDC.connectionDB();
        Statement statement = null;
        String query = String.format("" +
                "SELECT * FROM ADDRESSES;");

        List<Address> addresses = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            log.debug("Mostrando a lista de todos os endereços: ");

            while (rs.next()) {
                Address address = new Address(
                        rs.getInt("id"),
                        rs.getString("street"),
                        rs.getInt("number"),
                        rs.getString("city"),
                        rs.getString("state")
                );
                addresses.add(address);
                log.debug(address.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public void delete(Address address) {
        log.debug("Deletando o endereço: " + address.toString());
        Connection connection = CFG_JBDC.connectionDB();
        Statement statement = null;
        String query = String.format("" +
                "DELETE FROM ADDRESSES WHERE id=%s", address.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer update(String requisition, Integer id) {
        Connection connection = CFG_JBDC.connectionDB();
        Statement statement = null;
        String query = String.format("" +
                "UPDATE ADDRESSES SET " + requisition + " WHERE id=" + id);
        Integer rowsUpdated = 0;

        try {
            statement = connection.createStatement();
            rowsUpdated = statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(rowsUpdated == 0)
            log.debug("Nenhuma linha foi afetada com sua solicitação");
        else
            log.debug("As alterações foram realizadas");
        return rowsUpdated;
    }
}
