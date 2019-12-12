package com.glinka.mtab.service;

import com.glinka.mtab.model.Ticket;
import com.glinka.mtab.model.Trip;
import com.glinka.mtab.model.TripSchedule;
import com.glinka.mtab.repository.TripScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripScheduleServiceImpl implements TripScheduleService {

    private final TripScheduleRepository tripScheduleRepository;

    public TripScheduleServiceImpl(TripScheduleRepository tripScheduleRepository) {
        this.tripScheduleRepository = tripScheduleRepository;
    }

    @Override
    public List<TripSchedule> findAll() {
        return tripScheduleRepository.findAll();
    }

    @Override
    public List<TripSchedule> findAllByTripDetails(Trip trip) {
        return tripScheduleRepository.findAllByTripDetails(trip);
    }

    @Override
    public List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate) {
        return tripScheduleRepository.findAllByTripDetailsAndTripDate(trip, tripDate);
    }

    @Override
    public TripSchedule findById(Long id) {
        return tripScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public TripSchedule findByTicket(Ticket ticket) {
        return tripScheduleRepository.findByTicketSold(ticket);
    }

    @Override
    public TripSchedule save(TripSchedule tripSchedule) {
        return tripScheduleRepository.saveAndFlush(tripSchedule);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!tripScheduleRepository.existsById(id))
            return false;

        tripScheduleRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changeAvailableSeats(Long id, int availableSeats) {
        return false;
    }
}
