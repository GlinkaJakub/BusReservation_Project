package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityToDtoConverterImpl extends ConverterAdapter<RoleDto, Role> {

    @Override
    public RoleDto convert(RoleDto target, Role source) {
        if(target == null || source == null){
            return null;
        }
        target.setId(source.getId());
        target.setRole(source.getRole());

        return target;
    }
}
