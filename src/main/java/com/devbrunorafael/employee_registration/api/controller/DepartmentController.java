package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable Long id){
        return departmentService.findByCode(id);
    }

    @GetMapping
    public List<Department> findAllDepartments(){
        return departmentService.findAll();
    }

    @PostMapping("/cadastrar")
    public Department registerDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

}
