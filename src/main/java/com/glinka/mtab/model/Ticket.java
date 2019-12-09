package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    private int seatNumber;

    private Boolean cancellable;

    private String journeyDate;

    @OneToOne
    @JoinColumn(name = "userId")
    private User passenger;

    @ManyToOne
    @JoinColumn(name = "tripScheduleId")
    private TripSchedule tripSchedule;

}
