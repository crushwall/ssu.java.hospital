package com.hospital.controller;

import com.hospital.entity.Client;
import com.hospital.entity.Doctor;
import com.hospital.entity.PatientCard;
import com.hospital.service.ClientService;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientCardService;
import com.hospital.service.UserService;
import com.hospital.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Consumes;

@RestController
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

    private final UserService userService;
    private final ClientService clientService;
    private final PatientCardService cardService;
    private final DoctorService doctorService;

    @PostMapping(value = "/register/client")
    public String register(@RequestBody User user) {
        userService.registerUser(user, false);

        Client client = new Client();
        client.setUsername(user.getName());
        clientService.add(client);

        PatientCard card = new PatientCard();
        card.setClient(client);
        cardService.add(card);

        return "redirect:/";
    }

    @PostMapping(value = "/register/doctor")
    public String registerDoctor(@RequestBody User user) {
        userService.registerUser(user, true);

        Doctor doctor = new Doctor();
        doctor.setUsername(user.getName());
        doctorService.add(doctor);

        return "redirect:/";
    }

    @PostMapping(value = "/register/admin", consumes = {"application/xml","application/json"})
    public String registerAdmin(@RequestBody User user) {
        userService.registerAdmin(user);
        return "redirect:/";
    }
}
