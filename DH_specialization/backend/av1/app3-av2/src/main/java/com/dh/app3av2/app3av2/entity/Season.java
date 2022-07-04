package com.dh.app3av2.app3av2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Season {

    private String id;
    private Integer seasonNumber;
    private List<Chapter> chapters;

}
