package com.hospital.service.impl;

import com.hospital.entity.Role;
import com.hospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public Role getClientRole() {
        return getRole("ROLE_CLIENT");
    }

    public Role getDoctorRole() {
        return getRole("ROLE_DOCTOR");
    }

    private Role getRole(String roleName) {
        Optional<Role> roleUser = roleRepository.findByName(roleName);
        if (!roleUser.isPresent()) {
            Role role = new Role(roleName);
            roleRepository.save(role);

            return role;
        }

        return roleUser.get();
    }
}
