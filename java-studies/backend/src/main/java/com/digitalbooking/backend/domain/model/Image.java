package com.digitalbooking.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String title;
    private String url;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public boolean isNew() { return id != null; }
}
