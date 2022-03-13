package com.example.hateoasminiproject.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@Where(clause = "activated_status = true")
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
    private boolean activatedStatus = true;

    public boolean isNew() {
        return id != null;
    }

}
