package com.sport.mvc.authorization.dao;


import com.sport.mvc.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
