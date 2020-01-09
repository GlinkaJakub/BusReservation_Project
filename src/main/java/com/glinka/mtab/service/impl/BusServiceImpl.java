package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.BusDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;
import com.glinka.mtab.repository.AgencyRepository;
import com.glinka.mtab.repository.BusRepository;
import com.glinka.mtab.service.BusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    private final AgencyRepository agencyRepository;

    private final Converter<BusDto, Bus> busDtoToEntityConverter;
    private final Converter<Bus, BusDto> busEntityToDtoConverter;


    public BusServiceImpl(BusRepository busRepository, AgencyRepository agencyRepository, Converter<BusDto, Bus> busDtoToEntityConverter, Converter<Bus, BusDto> busEntityToDtoConverter) {
        this.busRepository = busRepository;
        this.agencyRepository = agencyRepository;
        this.busDtoToEntityConverter = busDtoToEntityConverter;
        this.busEntityToDtoConverter = busEntityToDtoConverter;
    }

    @Override
    public List<BusDto> findAll() {
        return busDtoToEntityConverter.convertToList(
                busRepository.findAll()
        );
    }

    @Override
    public List<Bus> findAllByAgency(Long agencyId) {
        Agency agency = agencyRepository.findById(agencyId).orElse(null);
        if (agency == null){
            return null;
        }
        return busRepository.findAllByAgency(agency);
    }

    @Override
    public Bus findById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    @Override
    public Bus save(BusDto busDto) {
        Bus bus = busEntityToDtoConverter.convert(busDto);
        return busRepository.saveAndFlush(bus);
    }

    @Override
    public boolean deleteById(Long id) {
        if(!busRepository.existsById(id))
        return false;

        busRepository.deleteById(id);
        return true;
    }
}
