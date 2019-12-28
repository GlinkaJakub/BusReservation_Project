package com.glinka.mtab.service;

import com.glinka.mtab.dto.TripScheduleDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;

import java.util.List;

public interface TripScheduleService {

    List<TripScheduleDto> findAll();

    List<TripSchedule> findAllByTripDetails(Trip trip);

    List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate);

    List<TripSchedule> findAllByAgency(Long agencyId);

    TripSchedule findById(Long id);

//    TripSchedule findByTicket(Ticket ticket);

    TripSchedule save(TripScheduleDto tripScheduleDto);

    boolean deleteById(Long id);

    boolean changeAvailableSeats(Long id, int availableSeats);

}
