package com.devbrunorafael.employee_registration.api.dto.outputs;

import com.devbrunorafael.employee_registration.domain.model.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeOutput {

    private Long id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String phone;
    private String email;
    private String position;
    private BigDecimal salary;
    private String department;

}
