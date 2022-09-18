package com.devbrunorafael.employee_registration.api.security.auth_persistence.model;

import com.devbrunorafael.employee_registration.api.security.auth_persistence.enums.RolesName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RolesName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
