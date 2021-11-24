package com.example.Clinic.dto;

import com.example.Clinic.persistence.entities.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private Integer id;
    private String name;
    private String surname;
    private AddressDTO addressDTO;

    public PatientDTO() {}

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.addressDTO = new AddressDTO(patient.getAddress());
    }
}
