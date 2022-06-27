package com.is_challenge.is_challenge.apiUser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.is_challenge.is_challenge.apiStreaming.entity.Score;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer role = 0;
    private Integer actions = 0;
    @OneToMany(
            mappedBy = "user"
    )
    @JsonIgnore
    private List<Score> scores = new ArrayList<>();


    public void addingActions(){
        ++actions;
    }
    public void permissionRole() {
        if (this.actions>0 &&  this.actions< 20) {
            this.role = 0;

        } else if (this.actions >= 20 && this.actions < 100) {
            this.role = 1;
        } else if (this.actions >= 100 && this.actions < 1000) {
            this.role = 2;
        }else {
            this.role = 3;
        }
    }

}
