package com.NMN.foodorder.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.NMN.foodorder.entities.Admin;
import com.NMN.foodorder.repositories.AdminRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminServices {

    private final AdminRepository adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    public Admin getAdmin(int id) {
        Optional<Admin> optional = adminRepository.findById(id);
        return optional.orElse(null); // Handle null if admin is not found
    }

    public void update(Admin admin, int id) {
        adminRepository.findById(id).ifPresent(existingAdmin -> {
            adminRepository.save(admin); // Save the updated admin directly
        });
    }

    public void delete(int id) {
        adminRepository.deleteById(id);
    }

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public boolean validateAdminCredentials(String email, String password) {
        Admin admin = adminRepository.findByAdminEmail(email);
        return admin != null && admin.getAdminPassword().equals(password);
    }
}