package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hospital.service.impl.ClientService;

@Controller
public class ClientsController {
    private final ClientService clientService;

    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView getClients(){
        ModelAndView modelAndView = new ModelAndView("clients/clients");
        modelAndView.addObject("clients", clientService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "clients/delete", params = "id", method = RequestMethod.GET)
    public ModelAndView deleteClient(@RequestParam(value = "id") int id){
        clientService.remove(id);
        ModelAndView modelAndView = new ModelAndView("clients/clients");
        modelAndView.addObject("clients", clientService.getAll());

        return modelAndView;
    }
}
