package com.glinka.mtab.service;

import com.glinka.mtab.dto.AgencyDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.User;

import java.util.List;

public interface AgencyService {

    List<AgencyDto> findAll();

    List<Agency> findAllByOwner(User user);
//    List<Agency> findAllByOwner(String user);

    Agency findById(Long Id);

    Agency findByName(String name);

    Agency save(AgencyDto agencyDto);

    boolean deleteById(Long id);

    boolean changeDetails(Long id, String details);

}
