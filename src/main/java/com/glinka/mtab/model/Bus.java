package com.glinka.mtab.model;

import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Data
@Entity
public class Bus {

    @Id
    @GeneratedValue
    private long id;

    private String code;
    private int capacity;
    private String make;

    @OneToOne
    @JoinColumn(name = "agencyId")
    private Agency agency;

}
