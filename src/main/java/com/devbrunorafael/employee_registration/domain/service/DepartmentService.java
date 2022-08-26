package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.api.controller.model.Department;
import com.devbrunorafael.employee_registration.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Transactional
    public Department findByCode(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public void deleteByCode(Long id) {
        departmentRepository.deleteById(id);
    }
}
