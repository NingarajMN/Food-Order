package com.NMN.foodorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.NMN.foodorder.entities.User;
import com.NMN.foodorder.services.UserServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServices services;

    @PostMapping("/addingUser")
    public String addUser(@ModelAttribute User user) {
        System.out.println(user);
        services.addUser(user);
        return "redirect:/admin/services";
    }

    @GetMapping("/updatingUser/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable("id") int id) {
        services.updateUser(user, id);
        return "redirect:/admin/services";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        services.deleteUser(id);
        return "redirect:/admin/services";
    }
}

