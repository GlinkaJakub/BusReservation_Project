package com.glinka.mtab.service;

import com.glinka.mtab.dto.BusDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;

import java.util.List;

public interface BusService {

    List<BusDto> findAll();

    List<Bus> findAllByAgency(Long agency);

    Bus findById(Long id);

    Bus save(BusDto busDto);

    boolean  deleteById(Long id);

}
