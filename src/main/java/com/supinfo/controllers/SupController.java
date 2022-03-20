package com.supinfo.controllers;
import com.supinfo.entities.UserEntity;
import com.supinfo.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(UserEntity user) {
        userService.save(user);

        return "";
    }

}