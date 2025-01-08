package com.login.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyOrdersController {

    @GetMapping("/orders")
    public String getOrders() {
        return "myorders";
    }
}
