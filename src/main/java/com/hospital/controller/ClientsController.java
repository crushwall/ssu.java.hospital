package com.hospital.controller;

import com.hospital.entity.Client;
import com.hospital.service.ClientService;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private DoctorService  doctorService;

    @Secured("ROLE_DOCTOR")
    @GetMapping(value = "/clients")
    public Iterable<Client> getClients(){
        return clientService.getAll();
    }

    @Secured("ROLE_CLIENT")
    @PostMapping(value = "/client/edit")
    public Client editClient(@RequestBody Client updatedClient){
        Client client = clientService.getByUsername(getCurrentUsername());

        client.setFirstName(updatedClient.getFirstName());
        client.setLastName(updatedClient.getLastName());
        client.setPhoneNumber(updatedClient.getPhoneNumber());
        client.setEmail(updatedClient.getEmail());
        client.setSex(updatedClient.getSex());
        client.setBirthday(updatedClient.getBirthday());

        clientService.update(client);
        return client;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/clients/add")
    public Iterable<Client> addClient(@RequestBody Client client){
        clientService.add(client);
        return clientService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "clients/delete", params = "id")
    public Iterable<Client> deleteClient(@RequestParam(value = "id") int id){
        clientService.remove(id);
        return clientService.getAll();
    }

    @Secured("ROLE_CLIENT")
    @GetMapping(value = "/profile")
    public Object getProfile() {
        String currentUserName = getCurrentUsername();
        Client client = clientService.getByUsername(currentUserName);

        if (client != null) {
            return client;
        } else {
            return doctorService.getByUsername(currentUserName);
        }
    }

    private String getCurrentUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();

        return userDetails.getUsername();
    }
}
