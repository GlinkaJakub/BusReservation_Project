package com.glinka.mtab.converter.entity;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.AgencyDto;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class AgencyDtoToEntityConverter extends ConverterAdapter<Agency, AgencyDto> {

    private final UserService userService;

    public AgencyDtoToEntityConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Agency convert(Agency target, AgencyDto source) {
        if(target == null || source == null)
            return null;

        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDetails(source.getDetails());
        target.setOwner(userService.findById(source.getOwner()));

        return target;
    }
}
