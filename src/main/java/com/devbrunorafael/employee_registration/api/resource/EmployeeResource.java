package com.devbrunorafael.employee_registration.api.resource;

import com.devbrunorafael.employee_registration.api.dto.request.EmployeeRequest;
import com.devbrunorafael.employee_registration.api.dto.response.EmployeeResponse;
import com.devbrunorafael.employee_registration.api.mapper.EmployeeMapper;
import com.devbrunorafael.employee_registration.domain.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmployeeResource implements RestMethods<EmployeeResponse, EmployeeRequest, Long> {

    private EmployeeMapper employeeMapper;
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    @Cacheable(value = "employee", key = "#id")
    @Override
    public ResponseEntity<EmployeeResponse> findOneById(@PathVariable("id") Long id){
        var employee = employeeService.findOneById(id);
        if(employee.isEmpty())
            return ResponseEntity.notFound().build();

        EmployeeResponse employeeResponse = employeeMapper.responseDTO(employee.get());
        return ResponseEntity.ok(employeeResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    @Cacheable(value = "employees")
    @Override
    public ResponseEntity<List<EmployeeResponse>> findAll(){
        var employeeList = employeeService.findAll();
        if(employeeList.isEmpty())
            return ResponseEntity.notFound().build();

        var employeeListResponse = employeeMapper.responseListDTO(employeeList.get());
        return ResponseEntity.ok(employeeListResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cadastrar")
    @CacheEvict(value = {"employee", "employees"}, allEntries = true)
    @Override
    public ResponseEntity<EmployeeResponse> registerEntity(@RequestBody EmployeeRequest employeeRequest){
        var employee = employeeMapper.requestDTO(employeeRequest);
        var employeeSaved = employeeService.save(employee);
        if(employeeSaved.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

        var employeeResponse = employeeMapper.responseDTO(employeeSaved.get());
        return ResponseEntity.ok(employeeResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/atualizar/{id}")
    @CacheEvict(value = {"employee", "employees"}, allEntries = true)
    @Override
    public ResponseEntity<EmployeeResponse> updateEntity(@PathVariable(name = "id") Long id,
                                                 @RequestBody EmployeeRequest employeeRequest){
        var employee = employeeMapper.requestDTO(employeeRequest);
        var employeeUpdated = employeeService.update(id, employee);
        if(employeeUpdated.isEmpty())
            ResponseEntity.notFound().build();

        var employeeResponse = employeeMapper.responseDTO(employeeUpdated.get());
        return ResponseEntity.ok(employeeResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/excluir/{id}")
    @Override
    public ResponseEntity<?> deleteEntity(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
