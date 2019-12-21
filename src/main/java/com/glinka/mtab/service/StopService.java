package com.glinka.mtab.service;

import com.glinka.mtab.dto.StopDto;
import com.glinka.mtab.model.entity.Stop;

import java.util.List;

public interface StopService {

    List<StopDto> findAll();

    Stop findById(Long id);

    Stop findByName(String name);

    Stop save(StopDto stopDto);

    boolean deleteById(Long id);

    boolean changeDetail(Long id, String detail);

}
