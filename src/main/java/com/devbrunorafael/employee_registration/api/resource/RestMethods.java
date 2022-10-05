package com.devbrunorafael.employee_registration.api.resource;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestMethods<RES, REQ, ID> {

    ResponseEntity<RES> findOneById(ID id);
    ResponseEntity<List<RES>> findAll();
    ResponseEntity<RES> registerEntity(REQ entity);
    ResponseEntity<RES> updateEntity(ID id, REQ entity);
    ResponseEntity<?> deleteEntity(ID id);

}
