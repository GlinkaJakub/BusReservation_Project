package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "login", columnDefinition = "VARCHAR(128)")
    private String login;

    @NotNull
    @Column(name = "password", columnDefinition = "VARCHAR(128)")
    private String password;

}
