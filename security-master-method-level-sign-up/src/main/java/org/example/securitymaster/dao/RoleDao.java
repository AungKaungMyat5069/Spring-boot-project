package org.example.securitymaster.dao;

import org.example.securitymaster.security.ds.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
