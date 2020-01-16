package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.BusDto;
import com.glinka.mtab.model.entity.Bus;
import com.glinka.mtab.service.AgencyService;
import org.springframework.stereotype.Component;

@Component
public class BusDtoToEntityConverter extends ConverterAdapter<Bus, BusDto> {

    private final AgencyService agencyService;

    public BusDtoToEntityConverter(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public Bus convert(Bus target, BusDto source) {
        if(target == null || source == null)
            return null;

        if (source.getId() != null)
            target.setId(source.getId());

        target.setCode(source.getCode());
        target.setCapacity(source.getCapacity());
        target.setMake(source.getMake());
        target.setAgency(agencyService.findById(source.getAgencyId()));

        return target;
    }
}
