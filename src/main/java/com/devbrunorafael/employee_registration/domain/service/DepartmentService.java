package com.devbrunorafael.employee_registration.domain.service;

import ch.qos.logback.core.joran.spi.EventPlayer;
import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Transactional
    public List<Employee> findEmployees(Long id){
        return this.findDepartmentById(id)
                .getEmployees();
    }

    @Transactional
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public List<Department> findDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

}
