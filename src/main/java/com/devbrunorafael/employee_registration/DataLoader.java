//package com.devbrunorafael.employee_registration;
//
//import com.devbrunorafael.employee_registration.api.security.auth_persistence.enums.RolesName;
//import com.devbrunorafael.employee_registration.api.security.auth_persistence.model.Role;
//import com.devbrunorafael.employee_registration.api.security.auth_persistence.model.User;
//import com.devbrunorafael.employee_registration.api.security.auth_persistence.repository.RoleRepository;
//import com.devbrunorafael.employee_registration.api.security.auth_persistence.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.Collections;
//
//
////@Component
//@AllArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    UserRepository userRepository;
//    RoleRepository roleRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Role role = new Role();
//        role.setRoleName(RolesName.ADMIN);
//        roleRepository.save(role);
//
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setRoles(Collections.singletonList(role));
//        userRepository.save(user);
//
//    }
//}
