package com.hospital.repository;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.PatientCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<Appointment> findById(long id);

    Iterable<Appointment> findByPatientCard(PatientCard patientCard);

    Iterable<Appointment> findByDoctor(Doctor doctor);

    void deleteById(long id);
}
