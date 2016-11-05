/**
 * 
 */
package com.sport.mvc.login_registration.service;

import com.sport.mvc.login_registration.dao.RoleDao;
import com.sport.mvc.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getAllUsers() {
		return roleDao.getAllUsers();
	}

	@Override
	public Role getRoleById(Long id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public boolean addRole(Role role) {
		return roleDao.addRole(role);
	}

	@Override
	public boolean roleExists(String roleName) {
		return roleDao.roleExists(roleName);
	}

}
