package com.hospital.controller;

import com.hospital.entity.Client;
import com.hospital.entity.Doctor;
import com.hospital.entity.User;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RestController
public class DoctorsController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/doctors")
    public Iterable<Doctor> getDoctors(){
        return doctorService.getAll();
    }

    @Secured("ROLE_DOCTOR")
    @PostMapping(value = "/doctor/edit")
    public Doctor editClient(@RequestBody Doctor updatedDoctor){
        Doctor doctor = doctorService.getByUsername(getCurrentUsername());

        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setSex(updatedDoctor.getSex());
        doctor.setBirthday(updatedDoctor.getBirthday());
        doctor.setEducation(updatedDoctor.getEducation());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        doctor.setEmploymentDate(updatedDoctor.getEmploymentDate());
        doctor.setStartWorkingTime(new Time(9, 0, 0));
        doctor.setEndWorkingTime(new Time(20, 0, 0));

        doctorService.update(doctor);
        return doctor;
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/doctors/add")
    public Iterable<Doctor> addDoctor(@RequestBody Doctor doctor){
        doctorService.add(doctor);
        return doctorService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "doctors/delete", params = "id")
    public Iterable<Doctor> deleteDoctor(@RequestParam(value = "id") int id){
        doctorService.remove(id);
        return doctorService.getAll();
    }

    private String getCurrentUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();

        return userDetails.getUsername();
    }
}