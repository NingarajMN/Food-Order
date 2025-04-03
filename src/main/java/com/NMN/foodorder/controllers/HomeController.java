package com.NMN.foodorder.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.NMN.foodorder.entities.Product;
import com.NMN.foodorder.loginCredentials.AdminLogin;
import com.NMN.foodorder.services.ProductServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductServices productServices;

    @GetMapping(value = {"/home", "/"})
    public String home() {
        return "Home";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> allProducts = productServices.getAllProducts();
        model.addAttribute("products", allProducts);
        return "Products";
    }

    @GetMapping("/location")
    public String location() {
        return "Locate_us";
    }

    @GetMapping("/about")
    public String about() {
        return "About";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("adminLogin", new AdminLogin());
        return "Login";
    }
}

