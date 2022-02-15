package com.hospital.service.impl;

import com.hospital.repository.CrudPatientCardRepository;
import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService implements com.hospital.service.CardService {
    @Autowired
    private CrudPatientCardRepository repository;

    @Override
    public void add(PatientCard patientCard) {
     repository.save(patientCard);
    }

    @Override
    public PatientCard getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<PatientCard> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(PatientCard patientCard) {
        repository.save(patientCard);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public PatientCard getByClient(Client client){
        return repository.findPatientCardByClient(client);
    }
}
