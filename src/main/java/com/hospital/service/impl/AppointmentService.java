package com.hospital.service.impl;

import com.hospital.repository.AppointmentRepository;
import com.hospital.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements com.hospital.service.AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    @Override
    public void add(Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    public Appointment getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
