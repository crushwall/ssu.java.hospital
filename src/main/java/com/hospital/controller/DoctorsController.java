package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hospital.service.DoctorService;

@Controller
public class DoctorsController {
    private final DoctorService doctorService;

    public DoctorsController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView getDoctors(){
        ModelAndView modelAndView = new ModelAndView("doctors/doctors");
        modelAndView.addObject("doctors", doctorService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "doctors/delete", params = "id", method = RequestMethod.GET)
    public String deleteDoctor(@RequestParam(value = "id") int id){
        doctorService.remove(id);

        return "redirect:/doctors";
    }
}
