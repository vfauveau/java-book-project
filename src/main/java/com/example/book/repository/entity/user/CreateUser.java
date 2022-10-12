package com.example.book.repository.entity.user;

public class CreateUser {

    private String email;
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
