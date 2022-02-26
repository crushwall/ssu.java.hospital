package com.hospital.controller;

import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import com.hospital.service.ClientService;
import com.hospital.service.PatientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientCardsController {
    @Autowired
    private PatientCardService cardService;

    @Autowired
    private ClientService clientService;

    @Secured("ROLE_DOCTOR")
    @GetMapping(value = "/cards")
    public Iterable<PatientCard> getCards(){
        return cardService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "cards/delete", params = "id")
    public Iterable<PatientCard> deleteCard(@RequestParam(value = "id") int id){
        cardService.remove(id);
        return cardService.getAll();
    }

    @Secured({"ROLE_CLIENT", "ROLE_DOCTOR"})
    @GetMapping(value = "/card")
    public PatientCard getCard(){
        Client client = clientService.getByUsername(getCurrentUsername());
        return cardService.getByClient(client);
    }

    private String getCurrentUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();

        return userDetails.getUsername();
    }
}