package com.glinka.mtab.model.dto;

import lombok.Data;

@Data
public class TripDto {

    private long id;
    private String journeyTime;
    private Long sourceStopId;
    private Long destStopId;
    private Long busId;
    private Long agencyId;

}
