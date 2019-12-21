package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.StopDto;
import com.glinka.mtab.model.entity.Stop;
import com.glinka.mtab.repository.StopRepository;
import com.glinka.mtab.service.StopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopService {

    private final StopRepository stopRepository;

    private final Converter<StopDto, Stop> stopDtoToEntityConverter;
    private final Converter<Stop, StopDto> stopEntityToDtoConverter;


    public StopServiceImpl(StopRepository stopRepository, Converter<StopDto, Stop> stopDtoToEntityConverter, Converter<Stop, StopDto> stopEntityToDtoConverter) {
        this.stopRepository = stopRepository;
        this.stopDtoToEntityConverter = stopDtoToEntityConverter;
        this.stopEntityToDtoConverter = stopEntityToDtoConverter;
    }

    @Override
    public List<StopDto> findAll() {
        return stopDtoToEntityConverter.convertToList(
                stopRepository.findAll()
        );
    }

    @Override
    public Stop findById(Long id) {
        return stopRepository.findById(id).orElse(null);
    }

    @Override
    public Stop findByName(String name) {
        return stopRepository.findByName(name);
    }

    @Override
    public Stop save(StopDto stopDto) {
        Stop stop = stopEntityToDtoConverter.convert(stopDto);
        return stopRepository.saveAndFlush(stop);
    }

    @Override
    public boolean deleteById(Long id) {
        if(!stopRepository.existsById(id))
            return false;

        stopRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changeDetail(Long id, String detail) {
        return false;
    }
}
