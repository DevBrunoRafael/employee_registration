package com.devbrunorafael.employee_registration.api.dto.response;

import com.devbrunorafael.employee_registration.domain.model.Department;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeResponse {

    private Long id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String phone;
    private String Email;
    private String position;
    private BigDecimal salary;
    private Department department;

}
