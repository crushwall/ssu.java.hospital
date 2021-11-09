package config;

import dao.fakeImpl.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration{
    @Bean
    public ClientRepository clientRepository() {
        return new ClientRepository();
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
