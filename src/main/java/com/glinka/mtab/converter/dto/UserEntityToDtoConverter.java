package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToDtoConverter extends ConverterAdapter<UserDto, User> {

    @Override
    public UserDto convert(UserDto target, User source) {
        if(target == null || source == null){
            return null;
        }
        target.setId(source.getId());
        target.setLogin(source.getLogin());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setRoleId(source.getRole().getId());

        return target;
    }
}
