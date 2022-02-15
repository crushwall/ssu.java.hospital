package com.hospital.service.impl;

import com.hospital.repository.ClientRepository;
import com.hospital.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements com.hospital.service.ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public void add(Client client) {
        repository.save(client);
    }

    @Override
    public Client getById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public Iterable<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Client client) {
        repository.save(client);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
