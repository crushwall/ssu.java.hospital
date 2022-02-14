package com.hospital.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client extends User{
    @OneToOne(fetch = FetchType.EAGER)
    private PatientCard patientCard;
}
