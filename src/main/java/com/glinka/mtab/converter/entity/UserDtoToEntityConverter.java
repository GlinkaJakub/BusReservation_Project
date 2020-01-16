package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityConverter extends ConverterAdapter<User, UserDto> {

    private final RoleService roleService;


    public UserDtoToEntityConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public User convert(User target, UserDto source) {
        if(target == null || source == null){
            return null;
        }
        if (source.getId() != null)
            target.setId(source.getId());

        target.setLogin(source.getLogin());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setRole(roleService.findById(source.getRoleId()));

        return target;
    }
}
