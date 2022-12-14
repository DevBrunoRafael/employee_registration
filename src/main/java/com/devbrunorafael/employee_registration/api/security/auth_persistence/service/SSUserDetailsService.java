package com.devbrunorafael.employee_registration.api.security.auth_persistence.service;

import com.devbrunorafael.employee_registration.api.security.auth_persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SSUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userModel = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username.concat(" not found!")));

        return new User(
                userModel.getUsername(), userModel.getPassword(),
                true, true,true,true,
                userModel.getAuthorities()
        );
    }
}
