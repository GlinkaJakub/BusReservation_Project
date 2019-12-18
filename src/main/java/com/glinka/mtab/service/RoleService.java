package com.glinka.mtab.service;

import com.glinka.mtab.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    Role save(RoleDto roleDto);

    boolean deleteById(Long id);

    Role findById(Long id);

}
