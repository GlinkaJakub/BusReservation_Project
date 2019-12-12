package com.glinka.mtab.service;

import com.glinka.mtab.model.Role;
import com.glinka.mtab.model.User;

import javax.persistence.Lob;
import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findAllByRole(Role role);
//    List<User> findAllByRole(String role);

    User findById(Long id);

    User findByLogin(String login);

    User save(User user);

    boolean deleteBiId(Long id);

    boolean changePassword(Long id, String newPassword);

}
