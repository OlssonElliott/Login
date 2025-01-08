package com.login.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.login.models.Product;
import com.login.login.repositories.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public String getProductInfo(Model model, @PathVariable Integer id) {
        Optional<Product> opProduct = productRepository.findById(id);
        if (opProduct != null) {
            Product product = opProduct.get();
            model.addAttribute("product", product);
        }
        return "productInfo";
    }

}
