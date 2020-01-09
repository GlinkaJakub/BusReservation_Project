package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.AgencyDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.repository.AgencyRepository;
import com.glinka.mtab.repository.BusRepository;
import com.glinka.mtab.service.AgencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final BusRepository busRepository;

    private final Converter<AgencyDto, Agency> agencyDtoToEntityConverter;
    private final Converter<Agency, AgencyDto> agencyEntityToDtoConverter;


    public AgencyServiceImpl(AgencyRepository agencyRepository, BusRepository busRepository, Converter<AgencyDto, Agency> agencyDtoToEntityConverter, Converter<Agency, AgencyDto> agencyEntityToDtoConverter) {
        this.agencyRepository = agencyRepository;
        this.busRepository = busRepository;
        this.agencyDtoToEntityConverter = agencyDtoToEntityConverter;
        this.agencyEntityToDtoConverter = agencyEntityToDtoConverter;
    }

    @Override
    public List<AgencyDto> findAll() {
        return agencyDtoToEntityConverter.convertToList(
                agencyRepository.findAll()
        );
    }

    @Override
    public List<Agency> findAllByOwner(User user) {
        return agencyRepository.findAllByOwner(user);
    }

    @Override
    public AgencyDto findDtoById(Long id) {
        return agencyDtoToEntityConverter.convert(
                agencyRepository.findById(id).orElse(null));
    }

    @Override
    public Agency findById(Long id) {
        return agencyRepository.findById(id).orElse(null);
    }

    @Override
    public Agency findByBus(Long busId) {
        Bus bus = busRepository.findById(busId).orElse(null);
        if (bus == null){
            return null;
        }
        Long agencyId = bus.getAgency().getId();
        return agencyRepository.findById(agencyId).orElse(null);
    }

    @Override
    public Agency findByName(String name) {
        return agencyRepository.findByName(name);
    }

    @Override
    public Agency save(AgencyDto agencyDto) {
        Agency agency = agencyEntityToDtoConverter.convert(agencyDto);
        return agencyRepository.saveAndFlush(agency);
    }

    @Override
    public boolean deleteById(Long id) {
        if(!agencyRepository.existsById(id))
            return false;

        agencyRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changeDetails(Long id, String details) {
//        if(!agencyRepository.existsById(id))
        return false;
    }
}
