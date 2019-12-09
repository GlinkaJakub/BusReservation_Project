package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Stop {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String name;
    private String details;


}
