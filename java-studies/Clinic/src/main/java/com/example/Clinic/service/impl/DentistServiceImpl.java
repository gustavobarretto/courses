package com.example.Clinic.service.impl;

import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.persistence.repository.impl.DentistRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements IClinicService<Dentist> {

    private DentistRepositoryImpl dentistRepository;

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.saveDentist(dentist);
    }

    @Override
    public Dentist findById(Integer id) {
        return dentistRepository.searchDentistById(id);
    }

    @Override
    public List<Dentist> searchAll() {
        return dentistRepository.findAllDentists();
    }

    @Override
    public void delete(Integer id) {
        dentistRepository.deleteDentistById(id);

    }

    @Override
    public Dentist update(Integer id, Dentist dentist) {
        return dentistRepository.updateDentist(dentist);
    }
}
