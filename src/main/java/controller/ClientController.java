package controller;

import config.AppConfiguration;
import model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.impl.ClientService;

@Controller
public class ClientController {
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView getClients(){
        ModelAndView modelAndView = new ModelAndView("clients");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ClientService clientService = context.getBean("clientService", ClientService.class);
        Client client = new Client();
        client.setFirstName("John");
        clientService.add(client);

        modelAndView.addAllObjects("client", client);

        return modelAndView;
    }
}
