package com.example.Clinic.services.impl;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IPatientRepository;
import com.example.Clinic.services.IClinicServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientService implements IClinicServices<Patient> {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Integer id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Patient update(Integer id, Patient patient) {
        return null;
    }
}
