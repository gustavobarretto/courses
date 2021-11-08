package service;

import dao.IDao;
import model.Patient;

import java.util.List;

public class PatientService {

    private IDao<Patient> patientIDao;
    private AddressService addressService;

    public PatientService(IDao<Patient> patientIDao,
                          AddressService addressService) {
        this.patientIDao = patientIDao;
        this.addressService = addressService;
    }

    public Patient save(Patient patient) {
        addressService.save(patient.getAddress());
        return patientIDao.save(patient);
    }

    public Patient search(Integer id) {
        return patientIDao.search(id);
    }

    public List<Patient> searchAllPatients() {
        return patientIDao.searchAll();
    }

    public void delete(Patient patient) {
        patientIDao.delete(patient);
        addressService.delete(patient.getAddress());
    }

    public Integer update(String requisition, Integer id) {
        return patientIDao.update(requisition, id);
    }
}
