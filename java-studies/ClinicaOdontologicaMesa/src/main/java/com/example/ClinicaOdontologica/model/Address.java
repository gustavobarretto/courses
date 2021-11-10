package com.example.ClinicaOdontologica.model;

public class Address {

    private String street;
    private String door_number;
    private String city;
    private String state;

    public Address(String street, String door_number, String city, String state) {
        this.street = street;
        this.door_number = door_number;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoor_number() {
        return door_number;
    }

    public void setDoor_number(String door_number) {
        this.door_number = door_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
