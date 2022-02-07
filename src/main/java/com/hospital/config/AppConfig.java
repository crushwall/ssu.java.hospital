package com.hospital.config;

import com.hospital.dao.fakeImpl.*;
import com.hospital.model.Appointment;
import com.hospital.model.Client;
import com.hospital.model.Doctor;
import com.hospital.model.PatientCard;
import com.hospital.model.enums.AppointmentStatus;
import com.hospital.model.enums.ClientStatus;
import com.hospital.model.enums.HumanSex;
import com.hospital.model.enums.Specialization;
import com.hospital.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class AppConfig {
    private final Client clientJohn = new Client(){
        {
            setFirstName("John");
            setLastName("White");
            setSex(HumanSex.Male);
            setBirthday(new Date(99, Calendar.JANUARY, 11));
            setPhoneNumber("7-123-44-55");

            setEmail("johnw@gmail.com");
            setUsername("super-john");
            setPassword("qwerty123");
        }
    };

    private final Client clientJuly = new Client(){
        {
            setFirstName("July");
            setLastName("Black");
            setSex(HumanSex.Female);
            setBirthday(new Date(88, Calendar.MARCH, 3));
            setPhoneNumber("7-123-55-44");

            setEmail("julyb@gmail.com");
            setUsername("hero-july");
            setPassword("123456");
        }
    };

    private final Doctor doctorWhite = new Doctor(){
        {
            setFirstName("Zeddan");
            setLastName("White");
            setSex(HumanSex.Male);
            setBirthday(new Date(88, Calendar.JANUARY, 3));
            setPhoneNumber("7-123-55-44");

            setEmail("zw@gmail.com");
            setUsername("mister-white");
            setPassword("123456");

            setEmploymentDate(new Date(15, Calendar.SEPTEMBER, 5));
            setEducation("Harvard");
            setSpecialization(Specialization.THERAPIST);
            setStartWorkingTime(new Time(8, 0, 0));
            setEndWorkingTime(new Time(17, 0, 0));
        }
    };

    private final Appointment appointment1 = new Appointment(){
        {
            setClientId(1);
            setDoctorId(1);
            setDate(LocalDateTime.parse("2022-02-15T09:00"));
            setAppointmentStatus(AppointmentStatus.ACTIVE);
            setClientStatus(ClientStatus.UNKNOWN);
        }
    };

    private final Appointment appointment2 = new Appointment(){
        {
            setClientId(1);
            setDoctorId(1);
            setDate(LocalDateTime.parse("2022-02-15T12:00"));
            setAppointmentStatus(AppointmentStatus.ACTIVE);
            setClientStatus(ClientStatus.UNKNOWN);
        }
    };

    private final Appointment appointment3 = new Appointment(){
        {
            setClientId(2);
            setDoctorId(1);
            setDate(LocalDateTime.parse("2022-02-15T10:00"));
            setAppointmentStatus(AppointmentStatus.ACTIVE);
            setClientStatus(ClientStatus.UNKNOWN);
        }
    };

    private final PatientCard card = new PatientCard(){
        {
            setClientId(1);
            setRecords(new ArrayList<>(Arrays.asList(appointment1, appointment2)));
        }
    };

    @Bean
    public ClientRepository clientRepository() {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(clientJohn);
        clientRepository.add(clientJuly);

        return clientRepository;
    }

    @Bean
    public DoctorRepository doctorRepository() {
        DoctorRepository doctorRepository = new DoctorRepository();
        doctorRepository.add(doctorWhite);

        return doctorRepository;
    }

    @Bean
    public AppointmentRepository appointmentRepository() {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.add(appointment1);
        appointmentRepository.add(appointment2);
        appointmentRepository.add(appointment3);

        return appointmentRepository;
    }

    @Bean
    public CardRepository cardRepository() {
        CardRepository cardRepository = new CardRepository();
        cardRepository.add(card);

        return cardRepository;
    }

    @Bean
    public ClientService clientService() { return new ClientService(); }

    @Bean
    public DoctorService doctorService() {
        return new DoctorService();
    }

    @Bean
    public AppointmentService appointmentService() {
        return new AppointmentService();
    }

    @Bean
    public CardService cardService() {
        return new CardService();
    }
}
