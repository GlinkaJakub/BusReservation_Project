package com.glinka.mtab.dto;

import com.glinka.mtab.model.entity.Stop;
import lombok.Data;

@Data
public class StopDto {

    private long id;
    private String code;
    private String name;
    private String details;

    public StopDto entityToDto(Stop stop){
        StopDto stopDto = new StopDto();
        stopDto.setId(stop.getId());
        stopDto.setCode(stop.getCode());
        stopDto.setName(stop.getName());
        stopDto.setDetails(stop.getDetails());

        return stopDto;
    }

    public Stop dtoToEntity(StopDto stopDto){
        Stop stop = new Stop();
        stop.setId(stopDto.getId());
        stop.setCode(stopDto.getCode());
        stop.setName(stopDto.getName());
        stop.setDetails(stopDto.getDetails());

        return stop;
    }

}
