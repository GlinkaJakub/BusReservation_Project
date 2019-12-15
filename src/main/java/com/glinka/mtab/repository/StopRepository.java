package com.glinka.mtab.repository;

import com.glinka.mtab.model.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop, Long> {

    Stop findByName(String name);

}
