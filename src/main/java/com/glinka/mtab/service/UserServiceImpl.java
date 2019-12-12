package com.glinka.mtab.service;

import com.glinka.mtab.model.Role;
import com.glinka.mtab.model.User;
import com.glinka.mtab.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User save(User user) {
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
