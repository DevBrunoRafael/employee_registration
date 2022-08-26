package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.api.controller.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}