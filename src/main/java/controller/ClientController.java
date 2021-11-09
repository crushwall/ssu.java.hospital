package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView clients(){
        ModelAndView modelAndView = new ModelAndView("clients");
        modelAndView.addAllObjects("", "");
        return modelAndView;
    }
}
