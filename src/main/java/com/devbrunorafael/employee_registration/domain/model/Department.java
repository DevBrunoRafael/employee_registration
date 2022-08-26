package com.devbrunorafael.employee_registration.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "cl_department")
public class Department {

    @Id
    private String code;
    private String name;
    private List<Employee> employees = new ArrayList<>();

}
