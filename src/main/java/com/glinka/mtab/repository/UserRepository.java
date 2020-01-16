package com.glinka.mtab.repository;

import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRole(Role role);
    User findByLogin(String login);

}
