package com.glinka.mtab.repository;

import com.glinka.mtab.model.Ticket;
import com.glinka.mtab.model.Trip;
import com.glinka.mtab.model.TripSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripScheduleRepository extends JpaRepository<TripSchedule, Long> {

    List<TripSchedule> findAllByTripDetails(Trip trip);

    List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate);

    TripSchedule findByTicketSold(Ticket ticket);

}
