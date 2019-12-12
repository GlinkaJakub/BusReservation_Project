package com.glinka.mtab.repository;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.Bus;
import com.glinka.mtab.model.Stop;
import com.glinka.mtab.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByAgency(Agency agency);

    List<Trip> findAllByBus(Bus bus);

    List<Trip> findAllBySourceStopAndDestStop(Stop sourceStop, Stop destStop);

    List<Trip> findAllBySourceStop(Stop sourceStop);

    List<Trip> findAllByDestStop(Stop destStop);
}
