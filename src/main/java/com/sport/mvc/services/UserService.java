package com.sport.mvc.services;

import com.sport.mvc.models.User;

import java.util.List;

/**
 * Created by admin on 12.10.2016.
 */
public interface UserService {
    List<User> getAll();

    void addUser(User user);
}
