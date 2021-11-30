package com.example.aula34integradora.entities;

import com.example.aula34integradora.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "pacotes")
public class PacoteEntity {
    @Id
    private String id;
    private Integer codigo;

    @Field("nome_produto")
    private String nomeProduto;
    private StatusEnum status;
    private DestinoEntity destino;

}
