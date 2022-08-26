package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.api.controller.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable Long id){
        return employeeService.findByCode(id);
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @PostMapping
    public Employee registerEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PostMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
       employeeService.deleteByCode(id);
    }

}
