package com.dh.app3av2.app3av2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("series")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serie {

    @Id
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;

}
