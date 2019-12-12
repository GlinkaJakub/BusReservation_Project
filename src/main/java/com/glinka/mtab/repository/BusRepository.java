package com.glinka.mtab.repository;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findAllByAgency(Agency agency);

}
