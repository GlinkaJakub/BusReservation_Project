package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, columnDefinition = "VARCHAR(128)")
    private String login;

    @NotNull
    @Column(unique = true, columnDefinition = "VARCHAR(128)")
    private String email;

    @NotNull
    @Column(columnDefinition = "VARCHAR(128)")
    private String password;

    @NotNull
    @Column(columnDefinition = "VARCHAR(128)")
    private String firstName;

    @NotNull
    @Column(columnDefinition = "VARCHAR(128)")
    private String lastName;

    @NotNull
    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;

}
