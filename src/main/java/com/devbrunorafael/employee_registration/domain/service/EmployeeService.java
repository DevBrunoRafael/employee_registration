package com.devbrunorafael.employee_registration.domain.service;


import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeesRepository employeesRepository;

    public Employee findByCode(String code){
        return employeesRepository.findById(code).get();
    }

    public List<Employee> findAll(){
        return employeesRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeesRepository.save(employee);
    }

    public Employee update(Employee employee){
        return employeesRepository.save(employee);
    }

    public void deleteByCode(String code){
        employeesRepository.deleteById(code);
    }

}
