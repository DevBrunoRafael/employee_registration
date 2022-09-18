package com.devbrunorafael.employee_registration.api.mapper;

import com.devbrunorafael.employee_registration.api.dto.request.EmployeeRequest;
import com.devbrunorafael.employee_registration.api.dto.response.EmployeeResponse;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmployeeMapper {

    private ModelMapper modelMapper;

    public EmployeeResponse responseDTO(Employee employee){
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    public Employee requestDTO(EmployeeRequest employeeRequest){
        return modelMapper.map(employeeRequest, Employee.class);
    }

    public List<EmployeeResponse> responseListDTO(List<Employee> employeeList){
        return employeeList.stream()
                .map(this::responseDTO)
                .collect(Collectors.toList());
    }

}
