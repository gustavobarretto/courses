package com.example.Clinic.dto;

import com.example.Clinic.entities.Pacient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacientDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer address_id;

    public PacientDTO() {}

    public PacientDTO(Pacient pacient) {
        this.id = pacient.getId();
        this.name = pacient.getName();
        this.surname = pacient.getSurname();
        this.address_id = pacient.getAddress().getId();
    }

}
