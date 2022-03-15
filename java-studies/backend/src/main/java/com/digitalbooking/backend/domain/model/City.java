package com.digitalbooking.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class City {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uudi2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String country;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "city"
    )
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public boolean isNew() { return id != null; }
 }
