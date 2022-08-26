package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    public Employee findEmployee(Long id){
        return employeeService.findById(id);
    }

    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    public Employee updateEmployee(Long id){
        return employeeService.updateById(id);
    }

    public void deleteEmployee(Long id){
       employeeService.delete(id);
    }

}
