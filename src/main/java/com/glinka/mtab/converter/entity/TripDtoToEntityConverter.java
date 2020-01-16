package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TripDto;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.service.AgencyService;
import com.glinka.mtab.service.BusService;
import com.glinka.mtab.service.StopService;
import org.springframework.stereotype.Component;

@Component
public class TripDtoToEntityConverter extends ConverterAdapter<Trip, TripDto> {

    private final StopService stopService;
    private final BusService busService;
    private final AgencyService agencyService;

    public TripDtoToEntityConverter(StopService stopService, BusService busService, AgencyService agencyService) {
        this.stopService = stopService;
        this.busService = busService;
        this.agencyService = agencyService;
    }

    @Override
    public Trip convert(Trip target, TripDto source) {
        if (target == null || source == null)
            return null;

        if (source.getId() != null)
            target.setId(source.getId());

        target.setFare(source.getFare());
        target.setJourneyTime(source.getJourneyTime());
        target.setSourceStop(stopService.findById(source.getSourceStopId()));
        target.setDestStop(stopService.findById(source.getDestStopId()));
        target.setBus(busService.findById(source.getBusId()));
        target.setAgency(agencyService.findById(source.getAgencyId()));

        return target;
    }
}
