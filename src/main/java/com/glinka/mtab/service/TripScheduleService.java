package com.glinka.mtab.service;

import com.glinka.mtab.model.Ticket;
import com.glinka.mtab.model.Trip;
import com.glinka.mtab.model.TripSchedule;

import java.util.List;

public interface TripScheduleService {

    List<TripSchedule> findAll();

    List<TripSchedule> findAllByTripDetails(Trip trip);

    List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate);

    TripSchedule findById(Long id);

    TripSchedule findByTicket(Ticket ticket);

    TripSchedule save(TripSchedule tripSchedule);

    boolean deleteById(Long id);

    boolean changeAvailableSeats(Long id, int availableSeats);

}
