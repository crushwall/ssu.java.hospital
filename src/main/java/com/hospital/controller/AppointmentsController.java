package com.hospital.controller;

import com.hospital.entity.Appointment;
import com.hospital.entity.Client;
import com.hospital.entity.Doctor;
import com.hospital.entity.PatientCard;
import com.hospital.enums.AppointmentStatus;
import com.hospital.service.AppointmentService;
import com.hospital.service.ClientService;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class AppointmentsController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PatientCardService  cardService;

    @Autowired
    private DoctorService doctorService;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/appointments")
    public Iterable<Appointment> getAppointments(){
        return appointmentService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/appointments/add")
    public Iterable<Appointment> addAppointment(@RequestBody Appointment appointment){
        appointmentService.add(appointment);

        PatientCard patientCard = cardService
                .getByClient(clientService.getById(appointment.getPatientCard().getClient().getId()));
        Set<Appointment> records = patientCard.getRecords();
        records.add(appointment);
        patientCard.setRecords(records);
        cardService.update(patientCard);

        return appointmentService.getAll();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "appointments/delete", params = "id")
    public Iterable<Appointment> deleteAppointment(@RequestParam(value = "id") int id){
        appointmentService.remove(id);
        return appointmentService.getAll();
    }

    @Secured({"ROLE_CLIENT", "ROLE_DOCTOR"})
    @GetMapping(value = "/my-appointments")
    public Iterable<Appointment> appointment(){
        String currentUsername = getCurrentUsername();
        Client client = clientService.getByUsername(currentUsername);
        if (client != null){
            PatientCard card = cardService.getByClient(client);
            return card.getRecords();
        }
        else {
            Doctor doctor = doctorService.getByUsername(currentUsername);
            return appointmentService.getByDoctor(doctor);
        }
    }

    @Secured("ROLE_DOCTOR")
    @PutMapping(value = "/my-appointments/done")
    public Iterable<Appointment> doneAppointment(@RequestParam(value = "id") long id){
        Appointment appointment = appointmentService.getById(id);
        appointment.setAppointmentStatus(AppointmentStatus.DONE);
        appointmentService.update(appointment);

        return appointmentService.getByDoctor(doctorService.getByUsername(getCurrentUsername()));
    }

    private String getCurrentUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();

        return userDetails.getUsername();
    }
}
