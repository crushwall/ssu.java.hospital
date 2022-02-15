package com.hospital.controller;

import com.hospital.entity.Client;
import com.hospital.entity.enums.HumanSex;
import com.hospital.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ClientEditingController {
    @Autowired
    private ClientService clientService;
    private boolean isNew;

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
    public String save(HttpServletRequest request,
                             @RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "first-name") String firstName,
                             @RequestParam(value = "last-name") String lastName,
                             @RequestParam(value = "birthday") String birthday,
                             @RequestParam(value = "sex") String sex,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password) throws ParseException {
        Client client = new Client();

        if (!isNew) {
            client.setId(id);
        }

        client.setFirstName(firstName);
        client.setLastName(lastName);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birthday);
        client.setBirthday(date);

        client.setSex(HumanSex.valueOf(sex));
        client.setPhoneNumber(phone);
        client.setEmail(email);
        client.setUsername(username);
        client.setPassword(password);

        if (isNew) {
            clientService.add(client);
        } else {
            clientService.update(client);
        }

        return "redirect:/clients";
    }
}
