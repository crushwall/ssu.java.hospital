package com.hospital.controller;

import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppointmentsController {
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public ModelAndView getAppointments(){
        ModelAndView modelAndView = new ModelAndView("appointments/appointments");
        modelAndView.addObject("appointments", appointmentService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "appointments/delete", params = "id", method = RequestMethod.GET)
    public String deleteAppointment(@RequestParam(value = "id") int id){
        appointmentService.remove(id);

        return "redirect:/appointments";
    }
}
