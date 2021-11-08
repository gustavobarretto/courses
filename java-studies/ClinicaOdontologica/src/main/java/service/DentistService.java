package service;

import dao.IDao;
import model.Dentist;

import java.util.List;

public class DentistService {

    private IDao<Dentist> dentistIDao;

    public DentistService(IDao<Dentist> dentistIDao) {
        this.dentistIDao = dentistIDao;
    }

    public Dentist save(Dentist dentist) {
        return dentistIDao.save(dentist);
    }

    public List<Dentist> searchAllDentists() {
        return dentistIDao.searchAll();
    }

    public Dentist search(Integer id) {
        return dentistIDao.search(id);
    }

    public void delete(Dentist dentist) {
        dentistIDao.delete(dentist);
    }

    public Integer update(String requistion, Integer id) {
        return dentistIDao.update(requistion, id);
    }
}
