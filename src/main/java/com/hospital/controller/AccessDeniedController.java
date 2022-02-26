package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {

    @ResponseBody
    @GetMapping("/access/denied")
    public ModelAndView accessDenied() {
        return new ModelAndView("error");
    }
}
