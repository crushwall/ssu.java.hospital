package com.hospital.entity;

import com.hospital.entity.enums.Specialization;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends User{
    @Temporal(TemporalType.DATE)
    private Date employmentDate;

    @Column
    private String education;

    @Enumerated(EnumType.ORDINAL)
    private Specialization specialization;

    @Column(columnDefinition = "TIME")
    private Time startWorkingTime;

    @Column(columnDefinition = "TIME")
    private Time endWorkingTime;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "record_id")
    private Set<Appointment> records;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
}
