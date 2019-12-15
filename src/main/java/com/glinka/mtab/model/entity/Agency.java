package com.glinka.mtab.model.entity;

import lombok.Data;
//import com.glinka.mtab.model.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Agency {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String code;

    @NotNull
    @Column(unique = true)
    private String name;

    private String details;

    @OneToOne
    @JoinColumn(name = "userId")
    private User owner;

}
