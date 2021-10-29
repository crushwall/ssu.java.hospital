package controller;

import config.AppConfiguration;
import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.impl.ClientService;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ClientService clientService = context.getBean("clientService", ClientService.class);

        clientService.add(new Client());
        clientService.getAll().forEach(System.out::println);
    }
}
