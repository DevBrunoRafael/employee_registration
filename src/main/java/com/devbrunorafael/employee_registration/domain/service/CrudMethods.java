package com.devbrunorafael.employee_registration.domain.service;

import java.util.List;
import java.util.Optional;

public interface CrudMethods<E> {

    Optional<E> findOneById(Long id);
    Optional<List<E>> findAll();
    Optional<E> save(E entity);
    Optional<E> update(Long id, E entity);
    void deleteById(Long id);

}
