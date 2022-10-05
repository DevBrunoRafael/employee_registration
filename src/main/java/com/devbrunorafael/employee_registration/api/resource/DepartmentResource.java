package com.devbrunorafael.employee_registration.api.resource;

import com.devbrunorafael.employee_registration.api.dto.request.DepartmentRequest;
import com.devbrunorafael.employee_registration.api.dto.response.DepartmentResponse;
import com.devbrunorafael.employee_registration.api.dto.response.EmployeeResponse;
import com.devbrunorafael.employee_registration.api.mapper.DepartmentMapper;
import com.devbrunorafael.employee_registration.api.mapper.EmployeeMapper;
import com.devbrunorafael.employee_registration.domain.service.DepartmentService;
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
@RequestMapping("/departamentos")
@AllArgsConstructor
public class DepartmentResource implements RestMethods<DepartmentResponse, DepartmentRequest, Long>{

    private DepartmentMapper departmentMapper;
    private EmployeeMapper employeeMapper;
    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    @Cacheable(value = "department", key = "#id")
    @Override
    public ResponseEntity<DepartmentResponse> findOneById(@PathVariable(name = "id") Long id) {
        var department = departmentService.findOneById(id);
        if(department.isEmpty())
            return ResponseEntity.notFound().build();

        var departmentResponse = departmentMapper.responseDTO(department.get());
        return ResponseEntity.ok(departmentResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    @Cacheable(value = "departments")
    @Override
    public ResponseEntity<List<DepartmentResponse>> findAll(){
        var departmentList = departmentService.findAll();
        if(departmentList.isEmpty())
            return ResponseEntity.notFound().build();

        var departmentListResponse = departmentMapper.responseListDTO(departmentList.get());
        return ResponseEntity.ok(departmentListResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/empregados")
    @Cacheable(value = "dpt-emp")
    public ResponseEntity<List<EmployeeResponse>> findDepartmentEmployees(@PathVariable("id") Long id){
         var employeesList = employeeService.findEmployeesByDepartment(id);
         if(employeesList.isEmpty())
             return ResponseEntity.notFound().build();

         var employeesListResponse = employeeMapper.responseListDTO(employeesList.get());
        return ResponseEntity.ok(employeesListResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cadastrar")
    @Override
    @CacheEvict(value = {"dpt-emp", "departments", "department"}, allEntries = true)
    public ResponseEntity<DepartmentResponse> registerEntity(@RequestBody DepartmentRequest departmentRequest){
        var department = departmentMapper.requestDTO(departmentRequest);
        var departmentSaved = departmentService.save(department);
        if(departmentSaved.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

        var departmentResponse = departmentMapper.responseDTO(departmentSaved.get());
        return ResponseEntity.ok(departmentResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    @CacheEvict(value = {"dpt-emp", "departments", "department"}, allEntries = true)
    @Override
    public ResponseEntity<DepartmentResponse> updateEntity(@PathVariable(name = "id") Long id,
                                                   @RequestBody DepartmentRequest departmentRequest){
        var department = departmentMapper.requestDTO(departmentRequest);
        var departmentUpdated = departmentService.update(id, department);
        if(departmentUpdated.isEmpty())
            ResponseEntity.notFound().build();

        var departmentResponse = departmentMapper.responseDTO(departmentUpdated.get());
        return ResponseEntity.ok(departmentResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> deleteEntity(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
