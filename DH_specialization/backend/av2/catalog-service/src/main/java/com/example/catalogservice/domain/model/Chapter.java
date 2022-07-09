package com.example.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chapter {

    private String id;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
}
