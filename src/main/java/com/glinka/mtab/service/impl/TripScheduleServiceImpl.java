package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.TripScheduleDto;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.repository.TripScheduleRepository;
import com.glinka.mtab.service.TripScheduleService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripScheduleServiceImpl implements TripScheduleService {

    private final TripScheduleRepository tripScheduleRepository;

    private final Converter<TripScheduleDto, TripSchedule> tripScheduleDtoToEntityConverter;
    private final Converter<TripSchedule, TripScheduleDto> tripScheduleEntityToDtoConverter;


    public TripScheduleServiceImpl(TripScheduleRepository tripScheduleRepository, @Lazy Converter<TripScheduleDto, TripSchedule> tripScheduleDtoToEntityConverter, @Lazy Converter<TripSchedule, TripScheduleDto> tripScheduleEntityToDtoConverter) {
        this.tripScheduleRepository = tripScheduleRepository;
        this.tripScheduleDtoToEntityConverter = tripScheduleDtoToEntityConverter;
        this.tripScheduleEntityToDtoConverter = tripScheduleEntityToDtoConverter;
    }

    @Override
    public List<TripScheduleDto> findAll() {
        return tripScheduleDtoToEntityConverter.convertToList(
                tripScheduleRepository.findAll()
        );
    }

    @Override
    public List<TripSchedule> findAllByTripDetails(Trip trip) {
        return tripScheduleRepository.findAllByTripDetails(trip);
    }

    @Override
    public List<TripSchedule> findAllByTripDetailsAndTripDate(Trip trip, String tripDate) {
        return tripScheduleRepository.findAllByTripDetailsAndTripDate(trip, tripDate);
    }

    @Override
    public TripSchedule findById(Long id) {
        return tripScheduleRepository.findById(id).orElse(null);
    }
//
//    @Override
//    public TripSchedule findByTicket(Ticket ticket) {
//        return tripScheduleRepository.findByTicketSold(ticket);
//    }

    @Override
    public TripSchedule save(TripScheduleDto tripScheduleDto) {
        TripSchedule tripSchedule = tripScheduleEntityToDtoConverter.convert(tripScheduleDto);
        return tripScheduleRepository.saveAndFlush(tripSchedule);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!tripScheduleRepository.existsById(id))
            return false;

        tripScheduleRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changeAvailableSeats(Long id, int availableSeats) {
        return false;
    }
}
