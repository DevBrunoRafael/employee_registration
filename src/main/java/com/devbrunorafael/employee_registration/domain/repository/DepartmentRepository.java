package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.domain.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}
