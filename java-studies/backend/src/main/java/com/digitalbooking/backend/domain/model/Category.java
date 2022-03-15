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
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String title;
    private String description;
    private String url;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "category"
    )
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public boolean isNew() { return id != null; }
}
