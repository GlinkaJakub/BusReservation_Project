package com.glinka.mtab.service;

import com.glinka.mtab.model.Stop;

import java.util.List;

public interface StopService {

    List<Stop> findAll();

    Stop findById(Long id);

    Stop findByName(String name);

    Stop save(Stop stop);

    boolean deleteById(Long id);

    boolean changeDetail(Long id, String detail);

}
