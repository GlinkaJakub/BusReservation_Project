package com.glinka.mtab.model;

import lombok.Data;
//import com.glinka.mtab.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Agency {

    @Id
    @GeneratedValue
    private long id;

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
