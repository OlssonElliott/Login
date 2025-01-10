package com.login.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.login.models.Product;
import com.login.login.models.User;
import com.login.login.repositories.UserRepository;
import com.login.login.repositories.ProductRepository;

//Controller för att hantera alla html och skapa ny user
@Controller
public class PageController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    // home---------------------------------------
    @GetMapping("/")
    public String goHome(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    // orders---------------------------------------
    @GetMapping("/orders")
    public String getOrders() {
        return "myorders";
    }

    // produkt---------------------------------------
    @GetMapping("/product/{id}")
    public String getProductInfo(Model model, @PathVariable Integer id) {
        Optional<Product> opProduct = productRepository.findById(id);
        if (opProduct != null) {
            Product product = opProduct.get();
            model.addAttribute("product", product);
        }
        return "productInfo";
    }

    // register---------------------------------------
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register-new")
    public String registerUser(@ModelAttribute User user) {
        String encryptedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "redirect:/";
    }
}
