package com.login.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.login.login.models.Product;
import com.login.login.repositories.ProductRepository;

@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String goHome(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

}
