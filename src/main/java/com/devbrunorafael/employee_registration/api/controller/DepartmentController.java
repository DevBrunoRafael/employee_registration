package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.api.controller.model.Department;
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

    @PostMapping
    public Department registerDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

    @PostMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        department.setId(id);
        return departmentService.update(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteByCode(id);
    }

}
