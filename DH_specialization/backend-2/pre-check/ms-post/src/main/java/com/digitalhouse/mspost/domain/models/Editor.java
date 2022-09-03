package com.digitalhouse.mspost.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditor;

    private String name;

}

