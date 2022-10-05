package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import com.devbrunorafael.employee_registration.domain.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService implements CrudMethods<Employee> {

    private EmployeesRepository employeesRepository;
    private DepartmentService departmentService;

    @Override
    public Optional<Employee> findOneById(Long id){
        var employee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("empregado não encontrado"));

        return Optional.of(employee);
    }

    @Override
    public Optional<List<Employee>> findAll(){
        var employeeList = employeesRepository.findAll();
        if(employeeList.size() == 0)
            throw new RuntimeException("não há empregados cadastrados");

        return Optional.of(employeeList);
    }

    public Optional<List<Employee>> findEmployeesByDepartment(Long id){
        var department = departmentService.findOneById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        var employeesList = employeesRepository.findEmployeesByDepartment(department);
        if(employeesList.size() == 0)
            throw new RuntimeException("não há empregados cadastrados nesse departamento");

        return Optional.of(employeesList);
    }

    @Override
    public Optional<Employee> save(Employee employee) {
        Department department = departmentService.findOneById(employee.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        employee.setDepartment (department);
        return Optional.of(employeesRepository.save(employee));
    }

    @Override
    public Optional<Employee> update(Long id, Employee employee){

        if(!employeesRepository.existsById(id))
            throw new RuntimeException("empregado não existe");

        employee.setId(id);
        return Optional.of(employeesRepository.save(employee));
    }

    @Override
    public void deleteById(Long id){

        if(!employeesRepository.existsById(id))
            throw new RuntimeException("empregado não existe");

        employeesRepository.deleteById(id);
    }

}
