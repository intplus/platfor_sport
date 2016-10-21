package com.sport.mvc.authorization.service;


import com.sport.mvc.authorization.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
