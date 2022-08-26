package com.devbrunorafael.employee_registration.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {

    private String code;
    private String name;
    private List<Employee> employees = new ArrayList<>();

}
