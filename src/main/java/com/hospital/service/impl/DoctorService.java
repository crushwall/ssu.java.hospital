package com.hospital.service.impl;

import com.hospital.repository.DoctorRepository;
import com.hospital.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements com.hospital.service.DoctorService {
    @Autowired
    private DoctorRepository repository;

    @Override
    public void add(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
