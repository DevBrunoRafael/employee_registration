package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/{code}")
    public Employee findEmployee(@PathVariable String code){
        return employeeService.findByCode(code);
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @PostMapping
    public Employee registerEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }


    @PostMapping("/{code}")
    public Employee updateEmployee(@PathVariable String code, @RequestBody Employee employee){
        employee.setCode(code);
        return employeeService.update(employee);
    }

    @DeleteMapping("/{code}")
    public void deleteEmployee(@PathVariable String code){
       employeeService.deleteByCode(code);
    }

}
