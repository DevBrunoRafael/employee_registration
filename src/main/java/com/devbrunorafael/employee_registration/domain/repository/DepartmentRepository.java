package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsDepartmentByName(String name);
}
