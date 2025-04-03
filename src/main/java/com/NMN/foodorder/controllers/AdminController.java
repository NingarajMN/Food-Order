package com.NMN.foodorder.controllers;

import java.util.Date;
import java.util.List;

import com.NMN.foodorder.entities.Orders;
import com.NMN.foodorder.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.NMN.foodorder.count.*;
import com.NMN.foodorder.entities.Product;
import com.NMN.foodorder.loginCredentials.*;
import com.NMN.foodorder.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

    @Controller
    @RequiredArgsConstructor
    public class AdminController {

        private final UserServices services;
        private final AdminServices adminServices;
        private final ProductServices productServices;
        private final OrderServices orderServices;

        private String email;
        private User user;

        @PostMapping("/adminLogin")
        public String getAllData(@ModelAttribute("adminLogin") AdminLogin login, Model model) {
            String email = login.getEmail();
            String password = login.getPassword();
            if (adminServices.validateAdminCredentials(email, password)) {
                return "redirect:/admin/services";
            } else {
                model.addAttribute("error", "Invalid email or password");
                return "Login";
            }
        }

        @PostMapping("/userLogin")
        public String userLogin(@ModelAttribute("userLogin") UserLogin login, Model model) {
            email = login.getUserEmail();
            String password = login.getUserPassword();
            if (services.validateLoginCredentials(email, password)) {
                user = services.getUserByEmail(email);
                List<Orders> orders = orderServices.getOrdersForUser(user);
                model.addAttribute("orders", orders);
                model.addAttribute("name", user.getUname());
                return "BuyProduct";
            } else {
                model.addAttribute("error2", "Invalid email or password");
                return "Login";
            }
        }

        @PostMapping("/product/search")
        public String searchHandler(@RequestParam("productName") String name, Model model) {
           Product product = productServices.getProductByName(name);
            List<Orders> orders = orderServices.getOrdersForUser(user);
            model.addAttribute("orders", orders);
            model.addAttribute("product", product);

            if (product == null) {
                model.addAttribute("message", "SORRY...! Product Unavailable");
            }

            return "BuyProduct";
        }

        @GetMapping("/admin/services")
        public String returnBack(Model model) {
            model.addAttribute("users", services.getAllUser());
            model.addAttribute("admins", adminServices.getAll());
            model.addAttribute("products", productServices.getAllProducts());
            model.addAttribute("orders", orderServices.getOrders());
            return "Admin_Page";
        }

        @GetMapping("/addAdmin")
        public String addAdminPage() {
            return "Add_Admin";
        }

        @PostMapping("addingAdmin")
        public String addAdmin(@ModelAttribute Admin admin) {
            adminServices.addAdmin(admin);
            return "redirect:/admin/services";
        }


    }

