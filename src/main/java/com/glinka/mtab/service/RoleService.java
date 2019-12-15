package com.glinka.mtab.service;

import com.glinka.mtab.model.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    Role save(RoleDto roleDto);

    boolean deleteById(Long id);

}
