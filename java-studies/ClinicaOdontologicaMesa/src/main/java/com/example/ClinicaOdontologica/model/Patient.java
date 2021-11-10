package com.example.ClinicaOdontologica.model;

public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String cpf;
    private String register_date;
    private Address address;

    public Patient(Integer id, String name, String surname, String email, String cpf, String register_date, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpf = cpf;
        this.register_date = register_date;
        this.address = address;
    }

    public Patient(String name, String surname, String email, String cpf, String register_date, Address address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpf = cpf;
        this.register_date = register_date;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
