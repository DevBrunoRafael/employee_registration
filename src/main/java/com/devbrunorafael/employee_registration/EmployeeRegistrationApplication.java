package com.devbrunorafael.employee_registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRegistrationApplication.class, args);
    }

}
