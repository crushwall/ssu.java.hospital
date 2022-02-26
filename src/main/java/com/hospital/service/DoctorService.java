package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repository;

    public void add(Doctor doctor) {
        repository.save(doctor);
    }

    public Doctor getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Doctor getByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public Iterable<Doctor> getAll() {
        return repository.findAll();
    }

    public void update(Doctor doctor) {
        repository.save(doctor);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}