
package com.sport.mvc.login_registration.service;


import com.sport.mvc.models.Role;

import java.util.List;


public interface RoleService {
	
	List<Role> getAllUsers();
	Role getRoleById(Long id);
	boolean addRole(Role role);
	boolean roleExists(String roleName);
}
