package com.hospital;

import com.hospital.config.AppConfig;
import com.hospital.entity.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.hospital.service.impl.ClientService;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientService clientService = context.getBean("clientService", ClientService.class);

        clientService.add(new Client());
        clientService.getAll().forEach(System.out::println);
    }
}
