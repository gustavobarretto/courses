import dao.impl.DentistDaoImpl;
import model.Dentist;
import org.junit.jupiter.api.Test;
import service.DentistService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DentistServiceTest {

    private DentistService dentistService = new DentistService(new DentistDaoImpl());
    Dentist dentist = new Dentist("REG123", "Gustavo", "Teles");

    @Test
    public void searchingDentist() {
        dentistService.save(dentist);
        assertTrue(dentist.getId() != null);
        Dentist dentistSearched = dentistService.search(dentist.getId());
        assertTrue(dentistSearched.getId() != null);
    }

    @Test
    public void searchingAllDentist() {
        Dentist dentist2 = new Dentist("REG321", "Sophia", "Fiama");
        dentistService.save(dentist);
        dentistService.save(dentist2);
        List<Dentist> dentistList = dentistService.searchAllDentists();
        assertFalse(dentistList.isEmpty());
    }

    @Test
    public void savingDentist() {
        dentistService.save(dentist);
        assertTrue(dentist.getId() != null);
    }

    @Test
    public void deletingDentist() {
        dentistService.save(dentist);
        assertTrue(dentist.getId() != null);
        dentistService.delete(dentist);
        assertTrue(dentistService.search(dentist.getId()) == null);
    }

    @Test
    public void updatingDentist() {
        Dentist dentist2 = new Dentist("REG321", "Sophia", "Fiama");
        dentistService.save(dentist2);
        dentistService.save(dentist);
        assertTrue(dentist.getId() != null);
        dentistService.update("name='Sophia doutrinadora de Java', lastname='e Javascript'", 2);
        Dentist dentistUpdated = dentistService.search(dentist.getId());
        Dentist dentistUpdated2 = dentistService.search(dentist2.getId());

        assertFalse(dentistUpdated.getId() != dentist.getId() && dentistUpdated.getName().equalsIgnoreCase(dentist.getName()));
        assertFalse(dentistUpdated2.getId() != dentist2.getId() && dentistUpdated2.getName().equalsIgnoreCase(dentist2.getName()));

        dentistService.searchAllDentists();
    }
}
