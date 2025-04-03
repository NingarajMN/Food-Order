package com.NMN.foodorder.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.NMN.foodorder.entities.Product;
import com.NMN.foodorder.services.ProductServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    // AddProduct
    @PostMapping("/addingProduct")
    public String addProduct(@ModelAttribute Product product) {
        productServices.addProduct(product);
        return "redirect:/admin/services";
    }

    // UpdateProduct
    @GetMapping("/updatingProduct/{productId}")
    public String updateProduct(@ModelAttribute Product product, @PathVariable("productId") int id) {
        productServices.updateproduct(product, id);
        return "redirect:/admin/services";
    }

    // DeleteProduct
    @GetMapping("/deleteProduct/{productId}")
    public String delete(@PathVariable("productId") int id) {
        productServices.deleteProduct(id);
        return "redirect:/admin/services";
    }
}

