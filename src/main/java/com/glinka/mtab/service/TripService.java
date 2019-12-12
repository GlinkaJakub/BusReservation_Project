package com.glinka.mtab.service;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.Bus;
import com.glinka.mtab.model.Stop;
import com.glinka.mtab.model.Trip;

import java.util.List;

public interface TripService {

    List<Trip> findAll();

    List<Trip> findAllByAgency(Agency agency);

    List<Trip> findAllByBus(Bus bus);

    List<Trip> findAllByStops(Stop sourceStop, Stop destStop);

    List<Trip> findAllBySourceStop(Stop sourceStop);

    List<Trip> findAllByDestStop(Stop destStop);

    Trip findById(Long id);

    Trip save(Trip trip);

    boolean deleteById(Long id);
}
