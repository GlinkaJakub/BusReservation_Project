package com.glinka.mtab.dto;

import lombok.Data;

@Data
public class TripViewDto {

    private Long id;
    private String sourceStop;
    private String destStop;
    private String tripDate;
    private int availableSeats;

}
