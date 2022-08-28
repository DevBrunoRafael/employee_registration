package com.devbrunorafael.employee_registration.api.dto.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeInput {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String position;
    @NotBlank
    private BigDecimal salary;
    @NotBlank
    private Long departmentId;

}
