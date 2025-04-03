package com.NMN.foodorder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.NMN.foodorder.entities.User;
import com.NMN.foodorder.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null); // Handle null if user is not found
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByUemail(email);
    }

    public void updateUser(User user, int id) {
        user.setU_id(id);
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean validateLoginCredentials(String email, String password) {
        return userRepository.findAll().stream().anyMatch(u ->
                u != null && u.getUpassword().equals(password) && u.getUemail().equals(email));
    }
}
