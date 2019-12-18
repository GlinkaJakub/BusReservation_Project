package com.glinka.mtab.service;

import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.model.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

//    List<UserDto> findAllByRole(Long role);
//    List<User> findAllByRole(String role);

    UserDto findById(Long id);

    UserDto findByLogin(String login);

    User save(UserDto user);

    boolean deleteBiId(Long id);

    boolean changePassword(Long id, String newPassword);

}
