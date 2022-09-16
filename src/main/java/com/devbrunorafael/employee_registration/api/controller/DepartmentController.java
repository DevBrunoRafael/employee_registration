package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/empregados")
    public ResponseEntity<Object> findDepartmentEmployees(@PathVariable(name = "id") Long id){
        List<Employee> employees = departmentService.findEmployees(id);

        if (employees.size() == 0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Não há funcionários cadastrados nesse departamento!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findDepartment(@PathVariable(name = "id") Long id) {
        Optional<Department> department = departmentService.findDepartmentById(id);

        if (department.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Departamento ".concat(String.valueOf(id)).concat(" não encontrado!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(department.get());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("all")
    public ResponseEntity<Object> findAllDepartments(){
        List<Department> departments = departmentService.findDepartments();

        if (departments.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não há departamentos cadastrados!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> registerDepartment(@RequestBody Department department){

        if (departmentService.existsName(department.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O departamento já existe!");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentService.saveDepartment(department));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDepartment(@PathVariable(name = "id") Long id,
                                                   @RequestBody Department department){
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);
        if (departmentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Departamento ".concat(String.valueOf(id)).concat(" não encontrado."));
        }
        department.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(departmentService.updateDepartment(department));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable(name = "id") Long id){
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (departmentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Departamento ".concat(String.valueOf(id)).concat(" não encontrado."));
        }
        return ResponseEntity.status(HttpStatus.OK).body("departamento excluído com sucesso!");
    }

}
