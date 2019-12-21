package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.TicketDto;
import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.repository.TicketRepository;
import com.glinka.mtab.repository.TripScheduleRepository;
import com.glinka.mtab.service.TicketService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final TripScheduleRepository tripScheduleRepository;

    private final Converter<TicketDto, Ticket> ticketDtoToEntityConverter;
    private final Converter<Ticket, TicketDto> ticketEntityToDtoConverter;


    public TicketServiceImpl(TicketRepository ticketRepository, TripScheduleRepository tripScheduleRepository, @Lazy Converter<TicketDto, Ticket> ticketDtoToEntityConverter, @Lazy Converter<Ticket, TicketDto> ticketEntityToDtoConverter) {
        this.ticketRepository = ticketRepository;
        this.tripScheduleRepository = tripScheduleRepository;
        this.ticketDtoToEntityConverter = ticketDtoToEntityConverter;
        this.ticketEntityToDtoConverter = ticketEntityToDtoConverter;
    }

    @Override
    public List<TicketDto> findAll() {
        return ticketDtoToEntityConverter.convertToList(
                ticketRepository.findAll()
        );
    }

    @Override
    public List<Ticket> findAllByPassenger(User passenger) {
        return ticketRepository.findAllByPassenger(passenger);
    }

    @Override
    public List<Ticket> findAllByTripSchedule(TripSchedule tripSchedule) {
        return ticketRepository.findAllByTripSchedule(tripSchedule);
    }

    @Override
    public List<Long> findAllByTripScheduleId(Long tripScheduleId){

        TripSchedule tripSchedule = tripScheduleRepository.findById(tripScheduleId).orElse(null);
        List<Ticket> tickets = ticketRepository.findAllByTripSchedule(tripSchedule);
        List<Long> ticketsId = new ArrayList<Long>();

        for (Ticket ticket : tickets){
            ticketsId.add(ticket.getId());
        }

        return ticketsId;
    }

    @Override
    public List<Ticket> findAllByCancellableAndTripSchedule(boolean cancellable, TripSchedule tripSchedule) {
        return ticketRepository.findAllByCancellableAndTripSchedule(cancellable, tripSchedule);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket findBySeatNumber(int seatNumber) {
        return ticketRepository.findBySeatNumber(seatNumber);
    }

    @Override
    public Ticket save(TicketDto ticketDto) {
        Ticket ticket = ticketEntityToDtoConverter.convert(ticketDto);
        return ticketRepository.saveAndFlush(ticket);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!ticketRepository.existsById(id))
            return false;

        ticketRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changeCancellable(Long id, boolean cancellable) {
        return false;
    }
}
