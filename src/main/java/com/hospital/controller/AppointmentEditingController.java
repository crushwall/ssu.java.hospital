package com.hospital.controller;

import com.hospital.entity.Appointment;
import com.hospital.entity.PatientCard;
import com.hospital.entity.enums.AppointmentStatus;
import com.hospital.entity.enums.ClientStatus;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDateTime;

@Controller
public class AppointmentEditingController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CardService cardService;
    private boolean isNew;

    @RequestMapping(value = "/appointment-editing/new", method = RequestMethod.GET)
    public ModelAndView load() {
        isNew = true;
        return new ModelAndView("appointments/appointment-editing");
    }

    @RequestMapping(value = "/appointment-editing/edit", params = "id", method = RequestMethod.GET)
    public ModelAndView loadById(@RequestParam(value = "id") int id) {
        isNew = false;

        Appointment appointment = appointmentService.getById(id);

        ModelAndView modelAndView = new ModelAndView("appointments/appointment-editing");
        modelAndView.addObject("appointment", appointment);
        modelAndView.addObject("card", appointment.getPatientCard());

        return modelAndView;
    }

    @RequestMapping(value = "/appointment-editing/save", method = RequestMethod.POST)
    public String save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "doctor-id") int doctorId,
                             @RequestParam(value = "client-id") int clientId,
                             @RequestParam(value = "date") String date,
                             @RequestParam(value = "appointment-status") String appointmentStatus,
                             @RequestParam(value = "client-status") String clientStatus) throws ParseException {
        Appointment appointment = new Appointment();

        if (!isNew) {
            appointment.setId(id);
        }

        appointment.setDoctor(doctorService.getById(doctorId));

        LocalDateTime appointmentDate = LocalDateTime.parse(date);
        appointment.setDate(appointmentDate);

        appointment.setAppointmentStatus(AppointmentStatus.valueOf(appointmentStatus));
        appointment.setClientStatus(ClientStatus.valueOf(clientStatus));

        PatientCard patientCard = cardService.getByClient(clientService.getById(clientId));
        appointment.setPatientCard(patientCard);

        if (isNew) {
            appointmentService.add(appointment);
        } else {
            appointmentService.update(appointment);
        }

        return "redirect:/appointments";
    }
}
