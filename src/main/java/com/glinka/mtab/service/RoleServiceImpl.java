package com.glinka.mtab.service;

import com.glinka.mtab.model.Role;
import com.glinka.mtab.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public boolean deleteById(Long id) {
        if(!roleRepository.existsById(id))
            return false;

        roleRepository.deleteById(id);
        return true;
    }
}
