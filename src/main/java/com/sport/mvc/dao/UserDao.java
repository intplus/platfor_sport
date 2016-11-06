package com.sport.mvc.dao;

import com.sport.mvc.models.User;

public interface UserDao extends ItemDao<User> {

    boolean addUser(User model);

    User getUserByUsername(String username);

    boolean userExists(String username);


}
