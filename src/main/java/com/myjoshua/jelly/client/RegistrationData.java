package com.myjoshua.jelly.client;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;


/**
 * Created by Jeremy on 7/4/2016.
 */
class RegistrationData {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max=120)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
