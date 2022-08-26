package com.devbrunorafael.employee_registration.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Department department;

}
