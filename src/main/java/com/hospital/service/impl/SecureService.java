package com.hospital.service.impl;

import com.hospital.entity.Client;
import com.hospital.entity.Role;
import com.hospital.repository.ClientRepository;
import com.hospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SecureService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        Optional<Client> userOptional = clientRepository.findClientByFirstName(firstName);
        return userOptional
                .map(this::toSpringClient)
                .orElseThrow(() -> new UsernameNotFoundException(firstName));
    }

    private org.springframework.security.core.userdetails.User toSpringClient(Client client) {
        return new org.springframework.security.core.userdetails.User(
                client.getFirstName(),
                client.getPassword(),
                (Collection<? extends GrantedAuthority>) client.getRole()
        );
    }
}