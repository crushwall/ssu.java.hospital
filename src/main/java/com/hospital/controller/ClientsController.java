package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hospital.service.ClientService;

@Controller
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @Secured("DOCTOR")
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView getClients(){
        ModelAndView modelAndView = new ModelAndView("clients/clients");
        modelAndView.addObject("clients", clientService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "clients/delete", params = "id", method = RequestMethod.GET)
    public String deleteClient(@RequestParam(value = "id") int id){
        clientService.remove(id);

        return "redirect:/clients";
    }
}
