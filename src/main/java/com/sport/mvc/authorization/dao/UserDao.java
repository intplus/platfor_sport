package com.sport.mvc.authorization.dao;

import com.sport.mvc.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
