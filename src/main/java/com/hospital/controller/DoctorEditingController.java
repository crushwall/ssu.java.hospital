package com.hospital.controller;

import com.hospital.model.Doctor;
import com.hospital.model.enums.HumanSex;
import com.hospital.model.enums.Specialization;
import com.hospital.service.impl.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class DoctorEditingController {
    private final DoctorService doctorService;
    private boolean isNew;

    public DoctorEditingController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/doctor-editing/new", method = RequestMethod.GET)
    public ModelAndView load() {
        isNew = true;
        return new ModelAndView("doctors/doctor-editing");
    }

    @RequestMapping(value = "/doctor-editing/edit", params = "id", method = RequestMethod.GET)
    public ModelAndView loadById(@RequestParam(value = "id") int id) {
        isNew = false;
        ModelAndView modelAndView = new ModelAndView("doctors/doctor-editing");
        modelAndView.addObject("doctor", doctorService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = "/doctor-editing/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                             @RequestParam(value = "first-name") String firstName,
                             @RequestParam(value = "last-name") String lastName,
                             @RequestParam(value = "birthday") String birthday,
                             @RequestParam(value = "sex") String sex,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "employment-date") String employmentDate,
                             @RequestParam(value = "education") String education,
                             @RequestParam(value = "specialization") String specialization,
                             @RequestParam(value = "start-working-time") String startWorkingTime,
                             @RequestParam(value = "end-working-time") String endWorkingTime) throws ParseException {
        Doctor doctor = new Doctor(){
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

                Date employment = format.parse(employmentDate);
                setEmploymentDate(employment);

                setEducation(education);
                setSpecialization(Specialization.valueOf(specialization));
                setStartWorkingTime(Time.valueOf(LocalTime.parse(startWorkingTime)));
                setEndWorkingTime(Time.valueOf(LocalTime.parse(endWorkingTime)));
            }
        };

        if (isNew){
            doctorService.add(doctor);
        }
        else{
            doctorService.update(doctor);
        }

        ModelAndView modelAndView = new ModelAndView("doctors/doctors");
        modelAndView.addObject("doctors", doctorService.getAll());

        return modelAndView;
    }
}
