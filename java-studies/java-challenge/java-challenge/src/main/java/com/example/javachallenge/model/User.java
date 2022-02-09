package com.example.javachallenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String email;
    private String role;
    boolean statusAccount;

    public User(){}

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.statusAccount = true;
        if(role == "USER") {
            this.role = Role.USER.getRole();
        }
        if(role == "ADMIN") {
            this.role = Role.ADMIN.getRole();
        }
    }
}
