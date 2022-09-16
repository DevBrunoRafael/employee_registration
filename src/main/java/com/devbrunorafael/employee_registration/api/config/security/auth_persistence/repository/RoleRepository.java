package com.devbrunorafael.employee_registration.api.config.security.auth_persistence.repository;

import com.devbrunorafael.employee_registration.api.config.security.auth_persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<User, Long> {
}
