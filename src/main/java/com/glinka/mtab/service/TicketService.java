package com.glinka.mtab.service;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    List<Ticket> findAllByPassenger(User passenger);

    List<Ticket> findAllByTripSchedule(TripSchedule tripSchedule);

    List<Ticket> findAllByCancellableAndTripSchedule(boolean cancellable, TripSchedule tripSchedule);

    Ticket findById(Long id);

    Ticket findBySeatNumber(int seatNumber);

    Ticket save(Ticket ticket);

    boolean deleteById(Long id);

    boolean changeCancellable(Long id, boolean cancellable);

}
