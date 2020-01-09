package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.TripDto;
import com.glinka.mtab.model.entity.*;
import com.glinka.mtab.repository.TripRepository;
import com.glinka.mtab.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    private final Converter<TripDto, Trip> tripDtoToEntityConverter;
    private final Converter<Trip, TripDto> tripEntityToDtoConverter;


    public TripServiceImpl(TripRepository tripRepository, Converter<TripDto, Trip> tripDtoToEntityConverter, Converter<Trip, TripDto> tripEntityToDtoConverter) {
        this.tripRepository = tripRepository;
        this.tripDtoToEntityConverter = tripDtoToEntityConverter;
        this.tripEntityToDtoConverter = tripEntityToDtoConverter;
    }

    @Override
    public List<TripDto> findAll() {
        return tripDtoToEntityConverter.convertToList(
                tripRepository.findAll()
        );
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
    public List<Trip> findAllBySourceStopAndDestStop(Stop source, Stop dest) {
        return tripRepository.findAllBySourceStopAndDestStop(source, dest);
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public Trip save(TripDto tripDto) {
        Trip trip = tripEntityToDtoConverter.convert(tripDto);
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
