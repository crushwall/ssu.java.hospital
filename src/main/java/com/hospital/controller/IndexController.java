package com.hospital.controller;

import com.hospital.entity.User;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping({"/", "/index"})
    public String index() {
        return "HOSPITAL";
    }

    @PostMapping("/admin")
    public String admin() {
        User user = new User();
        user.setName("admin");
        user.setPassword("admin");

        userService.registerAdmin(user);

        return "ADMIN CREATED";
    }
}
