package com.example.Clinic.persistence.entities;

import com.example.Clinic.dto.DentistDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "registration")
    private String registration;

    public Dentist(){}

    public Dentist(DentistDTO dentistDTO) {
        this.id = dentistDTO.getId();
        this.name = dentistDTO.getName();
        this.surname = dentistDTO.getSurname();
        this.registration = dentistDTO.getRegistration();
    }
}




