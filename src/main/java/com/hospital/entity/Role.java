package com.hospital.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @OneToMany(mappedBy = "role")
    private Collection<Client> clients;

    @OneToMany(mappedBy = "role")
    private Collection<Doctor> doctors;

    public static String clientRole() {
        return "ROLE_CLIENT";
    }

    public static String doctorRole() {
        return "ROLE_DOCTOR";
    }
}