package com.hospital.controller;

import com.hospital.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.service.ClientService;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public Iterable<Client> getClients(){
        return clientService.getAll();
    }

    @DeleteMapping(value = "clients/delete", params = "id")
    public Iterable<Client> deleteClient(@RequestParam(value = "id") int id){
        clientService.remove(id);
        return clientService.getAll();
    }
}
