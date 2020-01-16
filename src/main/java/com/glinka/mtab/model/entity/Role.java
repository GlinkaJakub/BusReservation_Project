package com.glinka.mtab.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(128)")
    private String role;

}
