package com.glinka.mtab.service;

import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Bus;

import java.util.List;

public interface BusService {

    List<Bus> findAll();

    List<Bus> findAllByAgency(Agency agency);

    Bus findById(Long id);

    Bus save(Bus bus);

    boolean  deleteById(Long id);

}
