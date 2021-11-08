import dao.impl.AddressDaoImpl;
import model.Address;
import org.junit.jupiter.api.Test;
import service.AddressService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressServiceTest {

    private AddressService addressService = new AddressService(new AddressDaoImpl());
    Address address1 = new Address("Rua Amazonas", 953, "Salvador", "Bahia");
    Address address2 = new Address("Rua Marília", 101, "Marília", "São Paulo");

    @Test
    public void savingAddress() {
        addressService.save(address1);
        assertTrue(address1.getId() != null);
    }

    @Test
    public void searchingAddress() {
        addressService.save(address1);
        assertTrue(address1.getId() != null);
        Address addressSearched = addressService.search(address1.getId());
        assertTrue(addressSearched.getId() == address1.getId());
    }

    @Test
    public void searchAllAddresses() {
        addressService.save(address1);
        addressService.save(address2);
        List<Address> addressList = addressService.searchAllAddresses();
        assertFalse(addressList.isEmpty());
    }

    @Test
    public void deletingAddress() {
        addressService.save(address1);
        assertTrue(address1.getId() != null);
        addressService.delete(address1);
        assertTrue(addressService.search(address1.getId()) == null);
    }

    @Test
    public void updatingDentist() {
        addressService.save(address1);
        addressService.save(address2);
        assertTrue(address1.getId() != null);
        addressService.update("street='Rua Maranhão'", 2);
        Address addressUpdated = addressService.search(address1.getId());
        Address addressUpdated2 = addressService.search(address2.getId());

        assertFalse(addressUpdated.getId() != address1.getId() && addressUpdated.getStreet().equalsIgnoreCase(address1.getStreet()));
        assertFalse(addressUpdated2.getId() != address2.getId() && addressUpdated2.getStreet().equalsIgnoreCase(address2.getStreet()));

        addressService.searchAllAddresses();
    }
}

