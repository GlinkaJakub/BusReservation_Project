package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoToEntityConverter extends ConverterAdapter<Role, RoleDto> {

    @Override
    public Role convert(Role target, RoleDto source) {
        if(target == null || source == null){
            return null;
        }
        target.setRole(source.getRole());

        return target;
    }
}
