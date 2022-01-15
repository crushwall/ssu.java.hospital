package com.hospital.dao.fakeImpl;

import com.hospital.model.Client;

import java.util.ArrayList;

public class ClientRepository implements com.hospital.dao.ClientRepository {
    private static ArrayList<Client> clients = new ArrayList<>();

    @Override
    public void add(Client client) {
        int id = clients
                .stream()
                .mapToInt(Client::getId)
                .max()
                .orElse(0);

        client.setId(++id);
        clients.add(client);
    }

    @Override
    public Client getById(int id) {
        return clients
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterable<Client> getAll() {
        return clients;
    }

    @Override
    public void update(Client client) {
        clients.remove(client.getId());
        clients.add(client);
    }

    @Override
    public void remove(int id) {
        clients.remove(id);
    }
}
