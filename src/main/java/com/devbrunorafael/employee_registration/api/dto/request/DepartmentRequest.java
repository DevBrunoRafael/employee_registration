package com.devbrunorafael.employee_registration.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DepartmentRequest {

    @NotBlank
    private String name;

}
