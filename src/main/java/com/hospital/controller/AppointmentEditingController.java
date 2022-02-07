package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.model.enums.AppointmentStatus;
import com.hospital.model.enums.ClientStatus;
import com.hospital.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class AppointmentEditingController {
    private final AppointmentService appointmentService;
    private boolean isNew;

    public AppointmentEditingController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping(value = "/appointment-editing/new", method = RequestMethod.GET)
    public ModelAndView load() {
        isNew = true;
        return new ModelAndView("appointments/appointment-editing");
    }

    @RequestMapping(value = "/appointment-editing/edit", params = "id", method = RequestMethod.GET)
    public ModelAndView loadById(@RequestParam(value = "id") int id) {
        isNew = false;
        ModelAndView modelAndView = new ModelAndView("appointments/appointment-editing");
        modelAndView.addObject("appointment", appointmentService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = "/appointment-editing/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "doctor-id") int doctorId,
                             @RequestParam(value = "client-id") int clientId,
                             @RequestParam(value = "date") String date,
                             @RequestParam(value = "appointment-status") String appointmentStatus,
                             @RequestParam(value = "client-status") String clientStatus) throws ParseException {
        Appointment appointment = new Appointment(){
            {
                if (!isNew){
                    setId(id);
                }

                setDoctorId(doctorId);
                setClientId(clientId);

                LocalDateTime appointmentDate = LocalDateTime.parse(date);
                setDate(appointmentDate);

                setAppointmentStatus(AppointmentStatus.valueOf(appointmentStatus));
                setClientStatus(ClientStatus.valueOf(clientStatus));
            }
        };

        if (isNew){
            appointmentService.add(appointment);
        }
        else{
            appointmentService.update(appointment);
        }

        ModelAndView modelAndView = new ModelAndView("appointments/appointments");
        modelAndView.addObject("appointments", appointmentService.getAll());

        return modelAndView;
    }
}
