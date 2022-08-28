package com.devbrunorafael.employee_registration.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String cpf;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String phone;
    private String email;

    private String position;
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
