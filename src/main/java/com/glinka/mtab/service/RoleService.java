package com.glinka.mtab.service;

import com.glinka.mtab.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role save(Role role);

    boolean deleteById(Long id);

}
