package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Transactional
    public List<Employee> findEmployees(Long id){
        Department department = departmentRepository.findById(id).get();
        return department.getEmployees();
    }

    @Transactional
    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Transactional
    public List<Department> findDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Transactional
    public void deleteDepartment(Department department){
        departmentRepository.delete(department);
    }

    @Transactional
    public boolean existsName(String name){
        return departmentRepository.existsDepartmentByName(name);
    }

}
