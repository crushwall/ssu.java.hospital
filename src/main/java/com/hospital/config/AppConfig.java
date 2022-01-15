package com.hospital.config;

import com.hospital.dao.fakeImpl.*;
import com.hospital.model.Client;
import com.hospital.model.enums.HumanSex;
import com.hospital.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public ClientRepository clientRepository() {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(clientJohn);
        clientRepository.add(clientJuly);

        return clientRepository;
    }

    @Bean
    public DoctorRepository doctorRepository() {
        return new DoctorRepository();
    }

    @Bean
    public AppointmentRepository appointmentRepository() {
        return new AppointmentRepository();
    }

    @Bean
    public CardRepository cardRepository() {
        return new CardRepository();
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
