package com.example.Clinic.service.impl;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.impl.PatientRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IClinicService<Patient> {

    private PatientRepositoryImpl patientRepository;


    @Override
    public Patient save(Patient patient) {
        return patientRepository.savePatient(patient);
    }

    @Override
    public Patient findById(Integer id) {
        return patientRepository.searchPatientById(id);
    }

    @Override
    public List<Patient> searchAll() {
        return patientRepository.findAllPatients();
    }

    @Override
    public void delete(Integer id) {
        patientRepository.deletePatientById(id);

    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.updatePatient(patient);
    }
}
