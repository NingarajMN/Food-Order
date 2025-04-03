package com.NMN.foodorder.loginCredentials;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLogin {
    @Email
    @NotNull
    private String userEmail;
    @NotNull
    private String userPassword;
}
