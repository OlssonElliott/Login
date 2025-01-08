package com.login.login.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.login.login.models.User;
import com.login.login.repositories.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {


    @Autowired
    private LoginRepository repository;

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") User user) {
        return user;
    }

}
