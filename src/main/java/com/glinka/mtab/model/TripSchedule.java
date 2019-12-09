package com.glinka.mtab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class TripSchedule {

    @Id
    @GeneratedValue
    private long id;

    private String tripDate;

    private int availableSeats;

    @OneToOne
    @JoinColumn(name = "tripId")
    private Trip tripDetails;

    @OneToMany
    @JoinColumn(name = "ticketId")
    private Set<Ticket> ticketSold;
}
