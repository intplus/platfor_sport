
package com.sport.mvc.login_registration.dao;


import com.sport.mvc.models.Role;

import java.util.List;


public interface RoleDao {
	
	List<Role> getAllUsers(); /// getAll

	Role getRoleById(Long id); /// getById

	boolean addRole(Role role); // add ???

	boolean roleExists(String name);
}
