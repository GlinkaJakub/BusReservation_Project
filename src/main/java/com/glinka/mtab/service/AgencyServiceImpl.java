package com.glinka.mtab.service;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.User;
import com.glinka.mtab.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    @Override
    public List<Agency> findAllByOwner(User user) {
        return agencyRepository.findAllByOwner(user);
    }

    @Override
    public Agency findById(Long id) {
        return agencyRepository.findById(id).orElse(null);
    }

    @Override
    public Agency findByName(String name) {
        return agencyRepository.findByName(name);
    }

    @Override
    public Agency save(Agency agency) {
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
