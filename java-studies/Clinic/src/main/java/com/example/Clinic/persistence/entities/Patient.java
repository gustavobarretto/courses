package com.example.Clinic.persistence.entities;

import com.example.Clinic.dto.AddressDTO;
import com.example.Clinic.dto.PatientDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Patient() {}

    public Patient(PatientDTO pacientDTO, AddressDTO addressDTO) {
        this.id = pacientDTO.getId();
        this.name = pacientDTO.getName();
        this.surname = pacientDTO.getSurname();
        this.address = addressDTO.toEntity();
    }

}
