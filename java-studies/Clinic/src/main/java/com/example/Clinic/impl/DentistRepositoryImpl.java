package com.example.Clinic.impl;

import com.example.Clinic.dto.DentistDTO;
import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.persistence.repository.IDentistRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DentistRepositoryImpl {
    private static Map<Integer, DentistDTO> dentistDTOMap = new HashMap<>();

    private IDentistRepository iDentistRepository;

    public Dentist saveDentist(Dentist dentist) {
        Dentist dentistSaved = iDentistRepository.save(dentist);
        DentistDTO dentistDTO = new DentistDTO(dentistSaved);
        dentistDTOMap.put(dentistSaved.getId(), dentistDTO);
        return dentistSaved;
    }

    public Dentist searchDentistById(Integer id) {
        Dentist dentistSearched = iDentistRepository.getById(id);
        DentistDTO dentistDTO = dentistDTOMap.get(dentistSearched.getId());
        if(dentistDTO != null)
            return new Dentist(dentistDTO);
        return null;
    }

    public List<Dentist> findAllDentists() {
        return iDentistRepository.findAll();
    }

    public void deleteDentistById(Integer id) {
        iDentistRepository.deleteById(id);
        dentistDTOMap.remove(id);
    }

    public Dentist updateDentist(Dentist dentist) { return null; }



}
