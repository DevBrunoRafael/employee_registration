package com.devbrunorafael.employee_registration.domain.repository;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends MongoRepository<Employee, String> {
}
