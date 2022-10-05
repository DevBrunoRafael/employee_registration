package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByDepartment(Department department);
}
