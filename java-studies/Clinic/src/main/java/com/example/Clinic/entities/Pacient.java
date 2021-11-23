package com.example.Clinic.entities;

import com.example.Clinic.dto.PacientDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pacient {

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

    public Pacient() {}

    public Pacient(PacientDTO pacientDTO, Address address) {
        this.id = pacientDTO.getId();
        this.name = pacientDTO.getName();
        this.surname = pacientDTO.getSurname();
        this.address = address;
    }
}
