package com.devbrunorafael.employee_registration.api.mapper;

import com.devbrunorafael.employee_registration.api.dto.inputs.EmployeeInput;
import com.devbrunorafael.employee_registration.api.dto.outputs.EmployeeOutput;
import com.devbrunorafael.employee_registration.domain.model.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapper {

    private ModelMapper modelMapper;

    public Employee toConvert(EmployeeInput employeeInput){
        return modelMapper.map(employeeInput, Employee.class);
    }

    public EmployeeOutput toConvert(Employee employee){
        return modelMapper.map(employee, EmployeeOutput.class);
    }

}
