package com.glinka.mtab.service.impl;

import com.glinka.mtab.converter.Converter;
import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.repository.RoleRepository;
import com.glinka.mtab.repository.UserRepository;
import com.glinka.mtab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final Converter<UserDto, User> userDtoToEntityConverter;
    private final Converter<User, UserDto> userEntityToDtoConverter;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, Converter<UserDto, User> userDtoToEntityConverter, Converter<User, UserDto> userEntityToDtoConverter) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userDtoToEntityConverter = userDtoToEntityConverter;
        this.userEntityToDtoConverter = userEntityToDtoConverter;
    }

    @Override
    public List<UserDto> findAll() {
        return userDtoToEntityConverter.convertToList(
                userRepository.findAll()
        );
    }

//    @Override
//    public List<UserDto> findAllByRole(Long role) {
//        return userDtoToEntityConverter.convertToList(
//                userRepository.findAllByRole(roleRepository.findById(role).orElse(null))
//        );
//    }

    @Override
    public UserDto findByIdDto(Long id) {
        return userDtoToEntityConverter.convert(
                userRepository.findById(id).orElse(null)
        );
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDto findByLogin(String login) {
        return userDtoToEntityConverter.convert(
                userRepository.findByLogin(login)
        );
    }

    @Override
    public User save(UserDto userDto) {
        User user = userEntityToDtoConverter.convert(userDto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean deleteBiId(Long id) {
        if (!userRepository.existsById(id))
            return false;

        userRepository.deleteById(id);
        return true;
    }

    //TODO
    @Override
    public boolean changePassword(Long id, String newPassword) {
        return false;
    }
}
