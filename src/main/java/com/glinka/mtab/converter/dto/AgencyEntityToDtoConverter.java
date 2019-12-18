package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.AgencyDto;
import com.glinka.mtab.model.entity.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyEntityToDtoConverter extends ConverterAdapter<AgencyDto, Agency> {

    @Override
    public AgencyDto convert(AgencyDto target, Agency source) {
        if(target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDetails(source.getDetails());
        target.setOwner(source.getOwner().getId());

        return target;
    }
}
