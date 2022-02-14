package com.hospital.entity;

import com.hospital.entity.enums.AppointmentStatus;
import com.hospital.entity.enums.ClientStatus;
import lombok.*;

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
    private int id;

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
