package com.NMN.foodorder.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.NMN.foodorder.entities.Product;
import com.NMN.foodorder.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepository productRepository;

    public void addProduct(Product p) {
        productRepository.save(p);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null); // Handle null if product is not found
    }

    public void updateProduct(Product p, int id) {
        p.setPid(id);
        productRepository.findById(id).ifPresent(existingProduct -> {
            productRepository.save(p); // Save the updated product directly
        });
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.findByPname(name); // Return product directly, null is handled implicitly
    }
}
