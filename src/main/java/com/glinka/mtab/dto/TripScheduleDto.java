package com.glinka.mtab.dto;

import lombok.Data;

import java.util.List;

@Data
public class TripScheduleDto {

    private long id;
    private int availableSeats;
    private Long tripDetailsId;
    private List<Long> ticketSoldId;

}
