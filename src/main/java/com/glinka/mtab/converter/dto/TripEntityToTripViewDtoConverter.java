package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TripViewDto;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.service.TripService;
import org.springframework.stereotype.Component;

@Component
public class TripEntityToTripViewDtoConverter extends ConverterAdapter<TripViewDto, TripSchedule> {

    private final TripService tripService;

    public TripEntityToTripViewDtoConverter(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public TripViewDto convert(TripViewDto target, TripSchedule source) {
        if (target == null || source == null)
            return null;
        Trip trip = tripService.findById(source.getTripDetails().getId());

        target.setId(source.getId());
        target.setSourceStop(trip.getSourceStop().getName());
        target.setDestStop(trip.getDestStop().getName());
        target.setTripDate(source.getTripDate());
        target.setAvailableSeats(source.getAvailableSeats());

        return target;
    }
}
