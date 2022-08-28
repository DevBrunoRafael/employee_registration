package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeesRepository employeesRepository;

    @Transactional
    public Employee findEmployeeById(Long id){
        return employeesRepository.findById(id).get();
    }

    @Transactional
    public List<Employee> findEmployees(){
        return employeesRepository.findAll();
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
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
