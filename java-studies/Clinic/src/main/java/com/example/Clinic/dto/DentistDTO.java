package com.example.Clinic.dto;

import com.example.Clinic.entities.Dentist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistDTO {

    private Integer id;
    private String name;
    private String surname;
    private String registration;

    public DentistDTO(){}

    public DentistDTO(Dentist dentist) {
        this.id = dentist.getId();
        this.name = dentist.getName();
        this.surname = dentist.getSurname();
        this.registration = dentist.getRegistration();
    }

}
