package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findEmployee(@PathVariable(name = "id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);

        if (employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee.get());
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllEmployees(){
        List<Employee> employees = employeeService.findEmployees();

        if (employees.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há funcionários cadastrados!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping("/cadastrar/{dptId}")
    public ResponseEntity<Object> registerEmployee(@PathVariable(name = "dptId") Long dptId,
                                                   @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(dptId, employee));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(name = "id") Long id,
                                                 @RequestBody Employee employee){
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if (employeeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionário não existe.");
        }
        employee.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteEmployee(@PathVariable(name = "id") Long id){
       Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

       if (employeeOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Empregado não encontrado.");
       }
       return ResponseEntity.status(HttpStatus.OK)
               .body("Empregado excluído com sucesso!");
    }

}
