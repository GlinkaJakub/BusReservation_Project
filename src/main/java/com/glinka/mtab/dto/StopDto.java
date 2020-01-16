package com.glinka.mtab.dto;

import com.glinka.mtab.model.entity.Stop;
import lombok.Data;

@Data
public class StopDto {

    private Long id;
    private String code;
    private String name;
    private String details;

}
