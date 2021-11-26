package com.example.Clinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Dentist.class)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
