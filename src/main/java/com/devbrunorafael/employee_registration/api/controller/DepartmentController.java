package com.devbrunorafael.employee_registration.api.controller;

import com.devbrunorafael.employee_registration.domain.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

}
