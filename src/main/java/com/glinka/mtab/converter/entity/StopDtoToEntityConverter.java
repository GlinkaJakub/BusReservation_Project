package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.StopDto;
import com.glinka.mtab.model.entity.Stop;
import org.springframework.stereotype.Component;

@Component
public class StopDtoToEntityConverter extends ConverterAdapter<Stop, StopDto> {

    @Override
    public Stop convert(Stop target, StopDto source) {
        if(source == null || target == null)
            return null;

        if (source.getId() != null)
            target.setId(source.getId());

        target.setName(source.getName());
        target.setCode(source.getCode());
        target.setDetails(source.getDetails());

        return target;
    }
}
