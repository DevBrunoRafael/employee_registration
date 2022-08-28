package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployee(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAllEmployees(){
        return employeeService.findEmployees();
    }

    @PostMapping("/cadastrar/{dptId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee registerEmployee(@PathVariable Long dptId, @RequestBody Employee employee){
        return employeeService.saveEmployee(dptId, employee);
    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable Long id){
       employeeService.deleteEmployeeById(id);
    }

}
