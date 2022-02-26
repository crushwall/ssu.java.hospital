package com.hospital.entity;

import com.hospital.enums.AppointmentStatus;
import com.hospital.enums.ClientStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue()
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @Column
    private LocalDateTime date;

    @Enumerated(EnumType.ORDINAL)
    private AppointmentStatus appointmentStatus;

    @Enumerated(EnumType.ORDINAL)
    private ClientStatus clientStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    private PatientCard patientCard;
}
