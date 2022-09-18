package com.devbrunorafael.employee_registration.api.dto.request;

import com.devbrunorafael.employee_registration.domain.model.Department;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private String phone;
    @NotBlank
    private String Email;
    @NotBlank
    private String position;
    @NotBlank
    private BigDecimal salary;
    @NotBlank
    private Department department;

}
