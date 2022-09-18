package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.api.dto.request.EmployeeRequest;
import com.devbrunorafael.employee_registration.api.dto.response.EmployeeResponse;
import com.devbrunorafael.employee_registration.api.mapper.EmployeeMapper;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeMapper employeeMapper;
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findEmployee(@PathVariable(name = "id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);

        if (employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeMapper.responseDTO(employee.get()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<Object> findAllEmployees(){
        List<Employee> employees = employeeService.findEmployees();

        if (employees.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há funcionários cadastrados!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeMapper.responseListDTO(employees));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cadastrar/{dptId}")
    public ResponseEntity<Object> registerEmployee(@PathVariable(name = "dptId") Long dptId,
                                                   @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeMapper.requestDTO(employeeRequest);
        EmployeeResponse response = employeeMapper
                .responseDTO(employeeService.saveEmployee(dptId, employee));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(name = "id") Long id,
                                                 @RequestBody EmployeeRequest employeeRequest){
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if (employeeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionário não existe.");
        }
        Employee employee = employeeMapper.requestDTO(employeeRequest);
        employee.setId(id);
        EmployeeResponse response = employeeMapper
                .responseDTO(employeeService.updateEmployee(employee));
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
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
