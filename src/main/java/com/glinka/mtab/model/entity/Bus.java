package com.glinka.mtab.model.entity;

import com.glinka.mtab.model.entity.Agency;
import lombok.Data;

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
