package com.glinka.mtab.dto;

import lombok.Data;

@Data
public class TicketDto {

    private long id;
    private int seatNumber;
    private Boolean cancellable;
    private String journeyDate;
    private Long passengerId;
    private Long tripscheduleId;

}
