package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TripScheduleDto;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.service.TicketService;
import com.glinka.mtab.service.TripScheduleService;
import com.glinka.mtab.service.TripService;
import org.springframework.stereotype.Component;

@Component
public class TripScheduleDtoToEntityConverter extends ConverterAdapter<TripSchedule, TripScheduleDto> {

    private final TripService tripService;
//    private final TicketService ticketService;
//    private final TripScheduleService tripScheduleService;

    public TripScheduleDtoToEntityConverter(TripService tripService) {
        this.tripService = tripService;
    }


    @Override
    public TripSchedule convert(TripSchedule target, TripScheduleDto source) {
        if(target == null || source == null)
            return null;

        target.setTripDate(source.getTripDate());
        target.setAvailableSeats(source.getAvailableSeats());
        target.setTripDetails(tripService.findById(source.getTripDetailsId()));
//        target.setTicketSold(null);

        return target;
    }
}
