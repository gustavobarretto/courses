package com.example.Clinic.persistence.repository.impl;

import com.example.Clinic.dto.PatientDTO;
import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PatientRepositoryImpl {
    private static Map<Integer, PatientDTO> patientDTOMap = new HashMap<>();

    @Autowired
    private AddressRepositoryImpl addressRepositoryImpl;

    @Autowired
    private IPatientRepository iPatientRepository;

    public PatientRepositoryImpl(IPatientRepository iPatientRepository) {
        this.iPatientRepository = iPatientRepository;
    }

    public Patient savePatient(Patient patient) {
        patient.setAddress(addressRepositoryImpl.saveAddress(patient.getAddress()));
        Patient patientSaved = iPatientRepository.save(patient);
        PatientDTO patientDTO = new PatientDTO(patientSaved);
        patientDTOMap.put(patientDTO.getId(), patientDTO);
        return new Patient(patientDTO, addressRepositoryImpl.searchAddressById(patientDTO.getAddress_id()));
    }

    public Patient searchPatientById(Integer id) {

        Patient patientSearched = iPatientRepository.getById(id);
        PatientDTO patientDTO = patientDTOMap.get(patientSearched.getId());
        if(patientDTO != null)
            return new Patient(patientDTO, addressRepositoryImpl.searchAddressById(patientDTO.getAddress_id()));
        return null;
    }

    public List<Patient> findAllPatients() {
        return iPatientRepository.findAll();
    }

    public void deletePatientById(Integer id) {
        iPatientRepository.deleteById(id);
        patientDTOMap.remove(id);
    }

    public Patient updatePatient(Patient patient) {
        return null;
    }

}


