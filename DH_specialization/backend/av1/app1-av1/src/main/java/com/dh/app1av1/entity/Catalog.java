package com.dh.app1av1.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Table(name = "catalog")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;
}
