package com.example.Clinic.persistence.entities;

import com.example.Clinic.dto.AddressDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;



    public Address(){}

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.getStreet();
        this.number = addressDTO.getNumber();
        this.state = addressDTO.getState();
        this.country = addressDTO.getCountry();
        this.postalCode = addressDTO.getPostalCode();
    }



}
