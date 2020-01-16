package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TicketDto;
import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.service.TripScheduleService;
import com.glinka.mtab.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoToEntityConverter extends ConverterAdapter<Ticket, TicketDto> {

    private final UserService userService;
    private final TripScheduleService tripScheduleService;

    public TicketDtoToEntityConverter(UserService userService,
                                      TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.tripScheduleService = tripScheduleService;
    }

    @Override
    public Ticket convert(Ticket target, TicketDto source) {
        if(target == null || source == null)
           return null;

        if (source.getId() != null)
            target.setId(source.getId());

        target.setSeatNumber(source.getSeatNumber());
        target.setCancellable(source.getCancellable());
        target.setJourneyDate(source.getJourneyDate());
        target.setPassenger(userService.findById(source.getPassengerId()));
        target.setTripSchedule(tripScheduleService.findById(source.getTripScheduleId()));

        return target;
    }
}
