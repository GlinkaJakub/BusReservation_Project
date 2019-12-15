package com.glinka.mtab.model.dto;

import com.glinka.mtab.model.entity.Role;
import lombok.Data;

@Data
public class RoleDto {

    private Long id;
    private String role;

    public RoleDto entityToDto(Role role){
        RoleDto roleDto = new RoleDto();
//        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());

        return roleDto;
    }

    public Role dtoToEntity(RoleDto roleDto){
        Role role = new Role();
//        role.setId(roleDto.getId());
        role.setRole(roleDto.getRole());

        return role;
    }
}
