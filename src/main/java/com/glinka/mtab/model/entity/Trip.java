package com.glinka.mtab.model.entity;

import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;
import com.glinka.mtab.model.entity.Stop;
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
    @JoinColumn(name = "sourceStopId")
    private Stop sourceStop;

    @OneToOne
    @JoinColumn(name = "destStopId")
    private Stop destStop;

    @OneToOne
    @JoinColumn(name = "busId")
    private Bus bus;

    @OneToOne
    @JoinColumn(name = "agencyId")
    private Agency agency;

}
