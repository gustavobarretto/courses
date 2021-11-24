package com.example.Clinic.persistence.repository.impl;

import com.example.Clinic.dto.PatientDTO;
import com.example.Clinic.persistence.entities.Address;
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

    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO, new Address(addressRepositoryImpl.saveAddress(patientDTO.getAddressDTO())));
        Patient patientSaved = iPatientRepository.save(patient);
        patientDTO.setId(patientSaved.getId());
        patientDTOMap.put(patientDTO.getId(), patientDTO);
        return patientDTO;
    }

    /*public Patient searchPatientById(Integer id) {

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
    }*/

}


