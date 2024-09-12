package com.example.diamond.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession session) {
        model.addAttribute("username", session.getAttribute("username"));
        return "/client/order/checkout";
    }
}
