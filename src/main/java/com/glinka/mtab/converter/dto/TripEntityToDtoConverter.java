package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TripDto;
import com.glinka.mtab.model.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripEntityToDtoConverter extends ConverterAdapter<TripDto, Trip> {

    @Override
    public TripDto convert(TripDto target, Trip source) {
        if(target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setFare(source.getFare());
        target.setJourneyTime(source.getJourneyTime());
        target.setSourceStopId(source.getSourceStop().getId());
        target.setDestStopId(source.getDestStop().getId());
        target.setBusId(source.getBus().getId());
        target.setAgencyId(source.getAgency().getId());

        return target;
    }
}
