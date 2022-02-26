package com.hospital.service;

import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import com.hospital.repository.PatientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCardService {
    @Autowired
    private PatientCardRepository repository;

    public void add(PatientCard patientCard) {
        repository.save(patientCard);
    }

    public PatientCard getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<PatientCard> getAll() {
        return repository.findAll();
    }

    public void update(PatientCard patientCard) {
        repository.save(patientCard);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }

    public PatientCard getByClient(Client client) {
        return repository.findByClient(client);
    }
}
