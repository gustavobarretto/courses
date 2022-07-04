package com.dh.app3av2.app3av2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {

    private String id;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
}
