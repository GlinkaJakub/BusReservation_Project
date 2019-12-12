package com.glinka.mtab.service;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.Bus;
import com.glinka.mtab.model.Stop;
import com.glinka.mtab.model.Trip;
import com.glinka.mtab.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public List<Trip> findAllByAgency(Agency agency) {
        return tripRepository.findAllByAgency(agency);
    }

    @Override
    public List<Trip> findAllByBus(Bus bus) {
        return tripRepository.findAllByBus(bus);
    }

    @Override
    public List<Trip> findAllByStops(Stop sourceStop, Stop destStop) {
        return tripRepository.findAllBySourceStopAndDestStop(sourceStop, destStop);
    }

    @Override
    public List<Trip> findAllBySourceStop(Stop sourceStop) {
        return tripRepository.findAllBySourceStop(sourceStop);
    }

    @Override
    public List<Trip> findAllByDestStop(Stop destStop) {
        return tripRepository.findAllByDestStop(destStop);
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public Trip save(Trip trip) {
        return tripRepository.saveAndFlush(trip);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!tripRepository.existsById(id))
            return false;

        tripRepository.deleteById(id);
        return true;
    }
}
