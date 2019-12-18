package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.StopDto;
import com.glinka.mtab.model.entity.Stop;
import org.springframework.stereotype.Component;

@Component
public class StopEntityToDtoConverter extends ConverterAdapter<StopDto, Stop> {

    @Override
    public StopDto convert(StopDto target, Stop source) {
        if (target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setName(source.getName());
        target.setCode(source.getCode());
        target.setDetails(source.getDetails());

        return target;
    }
}
