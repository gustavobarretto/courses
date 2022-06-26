package com.digitalhouse.registracion.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private Long id;

    private String name;

    private String genre;

    private String urlStream;
}
