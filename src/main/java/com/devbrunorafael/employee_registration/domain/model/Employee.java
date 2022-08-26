package com.devbrunorafael.employee_registration.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {

    private String code;
    private String name;
    private String birthDate;
    private BigDecimal salary;
    private Department department;

}
