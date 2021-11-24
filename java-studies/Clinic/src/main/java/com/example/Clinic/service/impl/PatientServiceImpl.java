package com.example.Clinic.service.impl;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IPatientRepository;
import com.example.Clinic.persistence.repository.impl.PatientRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IClinicService<Patient> {

    @Autowired
    public PatientRepositoryImpl patientRepository;

    @Override
    public Patient save(Patient patient) {
        System.out.println(patient.toString());
        System.out.println(patientRepository);
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
    public Patient update(Integer id, Patient patient) {
        return patientRepository.updatePatient(patient);
    }
}
