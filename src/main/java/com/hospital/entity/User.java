package com.hospital.entity;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class User extends Human {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    private Appointment appointment;
}
