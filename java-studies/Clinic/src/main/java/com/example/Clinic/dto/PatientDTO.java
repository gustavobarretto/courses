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
    private Integer address_id;

    public PatientDTO() {}

    public PatientDTO(Patient pacient) {
        this.id = pacient.getId();
        this.name = pacient.getName();
        this.surname = pacient.getSurname();
        this.address_id = pacient.getAddress().getId();
    }
}
