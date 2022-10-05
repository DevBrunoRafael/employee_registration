package com.devbrunorafael.employee_registration.domain.service;

import com.devbrunorafael.employee_registration.domain.model.Department;
import com.devbrunorafael.employee_registration.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DepartmentService implements CrudMethods<Department>{

    private DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> findOneById(Long id) {
        var department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        return Optional.of(department);
    }

    @Override
    public Optional<List<Department>> findAll() {
        var departmentList = departmentRepository.findAll();
        if(departmentList.size() == 0)
            throw new RuntimeException("Não há empregados cadastrados");

        return Optional.of(departmentList);
    }

    @Override
    public Optional<Department> save(Department department) {
        if(departmentRepository.existsDepartmentByName(department.getName()))
            throw new RuntimeException("Departamento já existe");

        return Optional.of(departmentRepository.save(department));
    }

    @Override
    public Optional<Department> update(Long id, Department department){

        if(departmentRepository.existsById(id))
            throw new RuntimeException("Departamento não existe");

        department.setId(id);
        return Optional.of(departmentRepository.save(department));
    }

    @Override
    public void deleteById(Long id){

        if(departmentRepository.existsById(id))
            throw new RuntimeException("Departamento não existe");

        departmentRepository.deleteById(id);
    }

}
