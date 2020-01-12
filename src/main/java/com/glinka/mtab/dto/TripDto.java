package com.glinka.mtab.dto;

import lombok.Data;

@Data
public class TripDto {

    private Long id;
    private int fare;
    private String journeyTime;
    private Long sourceStopId;
    private Long destStopId;
    private Long busId;
    private Long agencyId;

}
