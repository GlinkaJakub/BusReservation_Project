package com.glinka.mtab.service;

import com.glinka.mtab.model.Stop;
import com.glinka.mtab.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopService {

    private final StopRepository stopRepository;

    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public List<Stop> findAll() {
        return stopRepository.findAll();
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
    public Stop save(Stop stop) {
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
