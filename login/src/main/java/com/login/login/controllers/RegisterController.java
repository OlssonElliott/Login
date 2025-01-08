package com.login.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.login.models.User;
import com.login.login.repositories.LoginRepository;

@Controller
public class RegisterController {
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    LoginRepository loginRepository;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register-new")
    public String registerUser(@ModelAttribute User user) {
        String encryptedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        loginRepository.save(user);
        return "redirect:/";
    }
}
