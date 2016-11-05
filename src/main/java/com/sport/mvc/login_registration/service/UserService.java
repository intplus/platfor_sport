package com.sport.mvc.login_registration.service;


import com.sport.mvc.models.User;

import java.util.List;


public interface UserService {
	
	List<User> getAllUsers();
	User getUserById(Long id);
	User getUserByUsername(String username);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    boolean userExists(String username);

}
