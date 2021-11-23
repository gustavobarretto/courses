package com.example.Clinic.dto;


import com.example.Clinic.entities.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
public class AddressDTO {

    private Integer id;
    private String street;
    private String number;
    private String city;
    private String postalCode;
    private String country;
    private String state;

    public AddressDTO(){}

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.country = address.getCountry();
        this.state = address.getState();
    }


}
