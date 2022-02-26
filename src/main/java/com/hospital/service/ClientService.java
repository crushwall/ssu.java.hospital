package com.hospital.service;

import com.hospital.entity.Client;
import com.hospital.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public void add(Client client) {
        repository.save(client);
    }

    public Client getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Client getByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public Iterable<Client> getAll() {
        return repository.findAll();
    }

    public void update(Client client) {
        repository.save(client);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
