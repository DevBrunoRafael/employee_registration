package com.devbrunorafael.employee_registration.api.dto.request;

import com.devbrunorafael.employee_registration.domain.model.Department;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeRequest {

    @NotNull
    private Department department;
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
}
