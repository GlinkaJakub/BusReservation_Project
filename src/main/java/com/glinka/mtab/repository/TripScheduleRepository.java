package com.glinka.mtab.repository;

import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripScheduleRepository extends JpaRepository<TripSchedule, Long> {

    List<TripSchedule> findAllByTripDetails(Trip trip);

    List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate);

    TripSchedule findByTicketSold(Ticket ticket);

}
