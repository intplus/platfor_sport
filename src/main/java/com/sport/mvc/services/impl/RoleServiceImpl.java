package com.sport.mvc.services.impl;

import com.sport.mvc.dao.RoleDao;
import com.sport.mvc.models.Role;
import com.sport.mvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("roleDatabaseDao")
    private RoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Override
    public List<Role> getAllUsers() {
        return roleDao.getAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getById(id);
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
