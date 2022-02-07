package com.hospital.controller;

import com.hospital.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientCardsController {
    private final CardService cardService;

    public PatientCardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public ModelAndView getCards(){
        ModelAndView modelAndView = new ModelAndView("cards/cards");
        modelAndView.addObject("cards", cardService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "cards/delete", params = "id", method = RequestMethod.GET)
    public ModelAndView deleteCard(@RequestParam(value = "id") int id){
        cardService.remove(id);
        ModelAndView modelAndView = new ModelAndView("cards/cards");
        modelAndView.addObject("cards", cardService.getAll());

        return modelAndView;
    }
}
