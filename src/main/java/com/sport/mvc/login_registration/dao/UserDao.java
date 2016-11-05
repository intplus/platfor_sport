package com.sport.mvc.login_registration.dao;


import com.sport.mvc.models.User;

import java.util.List;


public interface UserDao {
	
	List<User> getAllUsers(); ///getAll

    User getUserById(Long id);/// getById

	User getUserByUsername(String username);

    boolean addUser(User user);///add

    void updateUser(User user); ///update

    void deleteUser(Long id); /// remove

    boolean userExists(String username);

}
