package com.hospital.controller;

import com.hospital.model.PatientCard;
import com.hospital.model.enums.HumanSex;
import com.hospital.service.AppointmentService;
import com.hospital.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class PatientCardEditingController {
    private final CardService cardService;
    private final AppointmentService appointmentService;
    private boolean isNew;

    public PatientCardEditingController(CardService cardService, AppointmentService appointmentService) {
        this.cardService = cardService;
        this.appointmentService = appointmentService;
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
        modelAndView.addObject("appointments", appointmentService.getAll());

        return modelAndView;
    }


    @RequestMapping(value = "/card-editing/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "first-name") int clientId,
                             @RequestParam(value = "appointment") ArrayList<Integer> apps) throws ParseException {
        PatientCard card = new PatientCard(){
            {
                if (!isNew){
                    setId(id);
                }

                setClientId(clientId);

            }
        };

        if (isNew){
            cardService.add(card);
        }
        else{
            cardService.update(card);
        }

        ModelAndView modelAndView = new ModelAndView("cards/cards");
        modelAndView.addObject("cards", cardService.getAll());

        return modelAndView;
    }
}
