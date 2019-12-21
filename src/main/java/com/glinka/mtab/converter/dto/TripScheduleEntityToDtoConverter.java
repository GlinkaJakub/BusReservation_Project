package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TripScheduleDto;
import com.glinka.mtab.model.entity.TripSchedule;
//import com.glinka.mtab.service.TicketService;
import com.glinka.mtab.service.TicketService;
import org.springframework.stereotype.Component;

@Component
public class TripScheduleEntityToDtoConverter extends ConverterAdapter<TripScheduleDto, TripSchedule> {

    private final TicketService ticketService;

    public TripScheduleEntityToDtoConverter(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public TripScheduleDto convert(TripScheduleDto target, TripSchedule source) {
        if (target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setTripDate(source.getTripDate());
        target.setAvailableSeats(source.getAvailableSeats());
        target.setTripDetailsId(source.getTripDetails().getId());
        target.setTicketSoldId(ticketService.findAllByTripScheduleId(source.getId()));

        return target;
    }
}
