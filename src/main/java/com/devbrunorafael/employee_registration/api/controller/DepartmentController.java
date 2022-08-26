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

    @GetMapping("/{code}")
    public Department findEmployee(@PathVariable String code){
        return departmentService.findByCode(code);
    }

    @GetMapping
    public List<Department> findAllEmployees(){
        return departmentService.findAll();
    }

    @PostMapping
    public Department registerEmployee(@RequestBody Department department){
        return departmentService.save(department);
    }

    @PostMapping("/{code}")
    public Department updateEmployee(@PathVariable String code, @RequestBody Department department){
        department.setCode(code);
        return departmentService.update(department);
    }

    @DeleteMapping("/{code}")
    public void deleteEmployee(@PathVariable String code){
        departmentService.deleteByCode(code);
    }

}
