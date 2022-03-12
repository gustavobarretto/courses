package com.example.hateoasminiproject.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private boolean activatedStatus;

    public boolean isNew() {
        return id != null;
    }

}
