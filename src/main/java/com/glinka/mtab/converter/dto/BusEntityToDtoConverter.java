package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.BusDto;
import com.glinka.mtab.model.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusEntityToDtoConverter extends ConverterAdapter<BusDto, Bus> {

    @Override
    public BusDto convert(BusDto target, Bus source) {
        if(target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setCapacity(source.getCapacity());
        target.setMake(source.getMake());
        target.setAgencyId(source.getAgency().getId());

        return target;
    }
}
