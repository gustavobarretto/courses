package com.example.Clinic.dto;

import com.example.Clinic.persistence.entities.Address;
import lombok.Getter;
import lombok.Setter;

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
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.country = address.getCountry();
        this.state = address.getState();
    }


}
