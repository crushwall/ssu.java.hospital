package com.hospital.service;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.PatientCard;
import com.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public void add(Appointment appointment) {
        repository.save(appointment);
    }

    public Appointment getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Appointment> getByPatientCard(PatientCard patientCard) {
        return repository.findByPatientCard(patientCard);
    }

    public Iterable<Appointment> getByDoctor(Doctor doctor) {
        return repository.findByDoctor(doctor);
    }

    public Iterable<Appointment> getAll() {
        return repository.findAll();
    }

    public void update(Appointment appointment) {
        repository.save(appointment);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }
}
