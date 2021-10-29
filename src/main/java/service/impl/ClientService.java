package service.impl;

import dao.ClientRepository;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService implements service.ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public void add(Client client) {
        repository.add(client);
    }

    @Override
    public Client getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Iterable<Client> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Client client) {
        repository.update(client);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
