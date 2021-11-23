package com.example.Clinic.repository.impl;

import com.example.Clinic.dto.PatientDTO;
import com.example.Clinic.entities.Patient;
import com.example.Clinic.repository.IPatientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepositoryImpl {
    private static Map<Integer, PatientDTO> patientDTOMap = new HashMap<>();

    private AddressRepositoryImpl addressRepositoryImpl;
    private IPatientRepository iPatientRepository;

    public PatientRepositoryImpl() {
        addressRepositoryImpl = new AddressRepositoryImpl();
    }

    public Patient save(Patient patient) {
        patient.setAddress(addressRepositoryImpl.save(patient.getAddress()));
        Patient patientSaved = iPatientRepository.save(patient);
        PatientDTO patientDTO = new PatientDTO(patientSaved);
        patientDTOMap.put(patientDTO.getId(), patientDTO);
        return patientSaved;
    }

    public Patient searchById(Integer id) {

        Patient patientSearched = iPatientRepository.getById(id);
        PatientDTO patientDTO = patientDTOMap.get(patientSearched.getId());
        if(patientDTO != null)
            return new Patient(patientDTO, addressRepositoryImpl.searchById(patientDTO.getAddressId()));
        return null;
    }

    public List<Patient> findAll() {
        return iPatientRepository.findAll();
    }

    public void deleteById(Integer id) {
        iPatientRepository.deleteById(id);
        patientDTOMap.remove(id);
    }

 Patient update(Patient patient) {
        return null;
    }

}


