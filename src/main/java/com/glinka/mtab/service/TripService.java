package com.glinka.mtab.service;

import com.glinka.mtab.dto.TripDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;
import com.glinka.mtab.model.entity.Stop;
import com.glinka.mtab.model.entity.Trip;

import java.util.List;

public interface TripService {

    List<TripDto> findAll();

    List<Trip> findAllByAgency(Agency agency);

    List<Trip> findAllByBus(Bus bus);

    List<Trip> findAllByStops(Stop sourceStop, Stop destStop);

    List<Trip> findAllBySourceStop(Stop sourceStop);

    List<Trip> findAllByDestStop(Stop destStop);

    Trip findById(Long id);

    Trip save(TripDto tripDto);

    boolean deleteById(Long id);
}
