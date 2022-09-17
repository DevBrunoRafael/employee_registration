package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeesRepository employeesRepository;
    private DepartmentService departmentService;

    @Transactional
    public Optional<Employee> findEmployeeById(Long id){
        return employeesRepository.findById(id);
    }

    @Transactional
    public List<Employee> findEmployees(){
        return employeesRepository.findAll();
    }

    @Transactional
    public Employee saveEmployee(Long dptId, Employee employee) {
        Department department = departmentService.findDepartmentById(dptId).get();
        employee.setDepartment(department);
        return employeesRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        return employeesRepository.save(employee);
    }

    @Transactional
    public void deleteEmployeeById(Long id){
        employeesRepository.deleteById(id);
    }

}
