package com.hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client extends Human {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String email;

    @Column
    private String username;

    @OneToOne(fetch = FetchType.EAGER)
    private Appointment appointment;

    @OneToOne(fetch = FetchType.EAGER)
    private PatientCard patientCard;
}
