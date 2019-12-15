package com.glinka.mtab.model.dto;

import lombok.Data;

@Data
public class AgencyDto {

    private Long id;
    private String code;
    private String name;
    private String details;
    private Long owner;

}
