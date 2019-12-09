package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue
    private long id;

    private int fare;

    private String journeyTime;

    @OneToOne
//    @JoinColumn(name = "stopId")
    private Stop sourceStop;

    @OneToOne
//    @JoinColumn(name = "stopId")
    private Stop destStop;

    @OneToOne
    @JoinColumn(name = "busId")
    private Bus bus;

    @OneToOne
    @JoinColumn(name = "agencyId")
    private Agency agency;

}
