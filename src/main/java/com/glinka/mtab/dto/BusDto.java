package com.glinka.mtab.dto;

import lombok.Data;

@Data
public class BusDto {

    private Long id;
    private String code;
    private int capacity;
    private String make;
    private Long agencyId;

}
