package com.glinka.mtab.dto;

import com.glinka.mtab.model.entity.Stop;
import lombok.Data;

@Data
public class StopDto {

    private long id;
    private String code;
    private String name;
    private String details;

}
