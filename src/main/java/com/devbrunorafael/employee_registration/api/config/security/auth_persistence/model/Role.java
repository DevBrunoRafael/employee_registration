package com.devbrunorafael.employee_registration.api.config.security.auth_persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
