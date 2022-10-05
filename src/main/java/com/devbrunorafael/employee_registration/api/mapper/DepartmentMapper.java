package com.devbrunorafael.employee_registration.api.mapper;

import com.devbrunorafael.employee_registration.api.dto.request.DepartmentRequest;
import com.devbrunorafael.employee_registration.api.dto.request.EmployeeRequest;
import com.devbrunorafael.employee_registration.api.dto.response.DepartmentResponse;
import com.devbrunorafael.employee_registration.api.dto.response.EmployeeResponse;
import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DepartmentMapper {

    private ModelMapper modelMapper;

    public DepartmentResponse responseDTO(Department department){
        return modelMapper.map(department, DepartmentResponse.class);
    }

    public Department requestDTO(DepartmentRequest departmentRequest){
        return modelMapper.map(departmentRequest, Department.class);
    }

    public List<DepartmentResponse> responseListDTO(List<Department> departmentList){
        return departmentList.stream()
                .map(this::responseDTO)
                .collect(Collectors.toList());
    }

}
