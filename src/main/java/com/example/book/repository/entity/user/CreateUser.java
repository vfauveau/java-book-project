package com.example.book.repository.entity.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUser {
    @NotNull
    @Email(message = "L'email doit etre valide")
    private String email;
    @NotNull
    @Size(min = 4)
    private String password;

    public CreateUser(){}

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
