package com.hospital.controller;

import com.hospital.model.Client;
import com.hospital.model.enums.HumanSex;
import com.hospital.service.impl.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ClientEditingController {
    private final ClientService clientService;
    private boolean isNew;

    public ClientEditingController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client-editing/new", method = RequestMethod.GET)
    public ModelAndView load() {
        isNew = true;
        return new ModelAndView("clients/client-editing");
    }

    @RequestMapping(value = "/client-editing/edit", params = "id", method = RequestMethod.GET)
    public ModelAndView loadById(@RequestParam(value = "id") int id) {
        isNew = false;
        ModelAndView modelAndView = new ModelAndView("clients/client-editing");
        modelAndView.addObject("client", clientService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = "/client-editing/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "first-name") String firstName,
                             @RequestParam(value = "last-name") String lastName,
                             @RequestParam(value = "birthday") String birthday,
                             @RequestParam(value = "sex") String sex,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password) throws ParseException {
        Client client = new Client(){
            {
                if (!isNew){
                    setId(id);
                }

                setFirstName(firstName);
                setLastName(lastName);

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(birthday);
                setBirthday(date);

                setSex(HumanSex.valueOf(sex));
                setPhoneNumber(phone);
                setEmail(email);
                setUsername(username);
                setPassword(password);
            }
        };

        if (isNew){
            clientService.add(client);
        }
        else{
            clientService.update(client);
        }

        ModelAndView modelAndView = new ModelAndView("clients/clients");
        modelAndView.addObject("clients", clientService.getAll());

        return modelAndView;
    }
}
