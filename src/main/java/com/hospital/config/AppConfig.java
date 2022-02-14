package com.hospital.config;

import com.hospital.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

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
