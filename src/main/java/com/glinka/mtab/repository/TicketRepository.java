package com.glinka.mtab.repository;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByPassenger(User passenger);

    List<Ticket> findAllByTripSchedule(TripSchedule tripSchedule);

    List<Ticket> findAllByCancellableAndTripSchedule(boolean cancellable, TripSchedule tripSchedule);

    Ticket findBySeatNumber(int seatNumber);

}
