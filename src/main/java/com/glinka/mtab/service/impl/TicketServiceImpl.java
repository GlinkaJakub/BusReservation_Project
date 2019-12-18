package com.glinka.mtab.service.impl;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.repository.TicketRepository;
import com.glinka.mtab.repository.TripScheduleRepository;
import com.glinka.mtab.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final TripScheduleRepository tripScheduleRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, TripScheduleRepository tripScheduleRepository) {
        this.ticketRepository = ticketRepository;
        this.tripScheduleRepository = tripScheduleRepository;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
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
    public Ticket save(Ticket ticket) {
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
