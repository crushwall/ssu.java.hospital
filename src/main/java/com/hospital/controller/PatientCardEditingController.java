package com.hospital.controller;

import com.hospital.entity.Appointment;
import com.hospital.entity.PatientCard;
import com.hospital.service.AppointmentService;
import com.hospital.service.CardService;
import com.hospital.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

@Controller
public class PatientCardEditingController {
    private final CardService cardService;
    private final AppointmentService appointmentService;
    private final ClientService clientService;
    private boolean isNew;

    public PatientCardEditingController(CardService cardService,
                                        AppointmentService appointmentService,
                                        ClientService clientService) {
        this.cardService = cardService;
        this.appointmentService = appointmentService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "/card-editing/new", method = RequestMethod.GET)
    public ModelAndView load() {
        isNew = true;
        ModelAndView modelAndView = new ModelAndView("cards/card-editing");
        modelAndView.addObject("appointments", appointmentService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/card-editing/edit", params = "id", method = RequestMethod.GET)
    public ModelAndView loadById(@RequestParam(value = "id") int id) {
        isNew = false;
        ModelAndView modelAndView = new ModelAndView("cards/card-editing");
        modelAndView.addObject("card", cardService.getById(id));
        modelAndView.addObject("records", appointmentService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/card-editing/save", method = RequestMethod.POST)
    public String save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "first-name") int clientId,
                             @RequestParam(value = "appointment", required = false, defaultValue = "") ArrayList<Integer> appointmentsIds) throws ParseException {
        PatientCard card = new PatientCard();

        if (!isNew){
            card.setId(id);
        }

        card.setClient(clientService.getById(clientId));

        if (card.getRecords() == null){
            HashSet<Appointment> records = new HashSet<>();
            appointmentsIds.forEach(appointmentId -> {
                records.add(appointmentService.getById(appointmentId));
            });

            card.setRecords(records);
        }
        else{
            appointmentsIds.forEach(appointmentId -> {
                card.getRecords().add(appointmentService.getById(appointmentId));
            });
        }


        if (isNew){
            cardService.add(card);
        }
        else{
            cardService.update(card);
        }

        return "redirect:/cards";
    }
}
