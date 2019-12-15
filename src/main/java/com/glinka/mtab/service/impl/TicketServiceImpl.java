package com.glinka.mtab.service.impl;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.repository.TicketRepository;
import com.glinka.mtab.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
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
