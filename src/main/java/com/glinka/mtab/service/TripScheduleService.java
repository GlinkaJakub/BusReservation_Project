package com.glinka.mtab.service;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;

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
