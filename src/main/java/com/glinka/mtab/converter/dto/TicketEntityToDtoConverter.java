package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TicketDto;
import com.glinka.mtab.model.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketEntityToDtoConverter extends ConverterAdapter<TicketDto, Ticket> {

    @Override
    public TicketDto convert(TicketDto target, Ticket source) {
        if(target == null || source == null)
            return null;

        target.setId(source.getId());
        target.setSeatNumber(source.getSeatNumber());
        target.setCancellable(source.getCancellable());
        target.setJourneyDate(source.getJourneyDate());
        target.setPassengerId(source.getPassenger().getId());
        target.setTripScheduleId(source.getTripSchedule().getId());

        return target;
    }
}
