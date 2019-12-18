package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.repository.RoleRepository;
import com.glinka.mtab.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final Converter<RoleDto, Role>  roleDtoToEntityConverter;
    private final Converter<Role, RoleDto> roleEntityToDtoConverter;

    public RoleServiceImpl(RoleRepository roleRepository, Converter<RoleDto, Role> roleDtoToEntityConverter, Converter<Role, RoleDto> roleEntityToDtoConverter) {
        this.roleRepository = roleRepository;
        this.roleDtoToEntityConverter = roleDtoToEntityConverter;
        this.roleEntityToDtoConverter = roleEntityToDtoConverter;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleDtoToEntityConverter.convertToList(
                roleRepository.findAll()
        );
//        return roleRepository.findAll();
//        return new ModelMapper().map(roles, listType);
    }

    @Override
    public Role findById(Long id) {
        System.out.println(roleRepository.findById(id).orElse(null));
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(RoleDto roleDto) {
        Role role = roleEntityToDtoConverter.convert(roleDto);
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
