package com.example.Clinic.service.impl;

import com.example.Clinic.dto.PatientDTO;
import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IPatientRepository;
import com.example.Clinic.persistence.repository.impl.PatientRepositoryImpl;
import com.example.Clinic.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IClinicService<PatientDTO> {

    @Autowired
    public PatientRepositoryImpl patientRepository;

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        return patientRepository.savePatient(patientDTO);
    }

    @Override
    public PatientDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<PatientDTO> searchAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public PatientDTO update(Integer id, PatientDTO patientDTO) {
        return null;
    }

    /*@Override
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
    }*/
}
