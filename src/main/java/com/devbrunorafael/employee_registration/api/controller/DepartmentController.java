package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department findDepartment(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAllDepartments(){
        return departmentService.findDepartments();
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Department registerDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

}
