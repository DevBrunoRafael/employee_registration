package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> { }
