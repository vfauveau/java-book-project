package com.example.book.controller;

import com.example.book.repository.entity.user.CreateUser;
import com.example.book.repository.entity.user.User;
import com.example.book.repository.entity.user.UserRepository;
import com.example.book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "userRegister";

    }

    @PostMapping("/register")
    public String createUser(CreateUser createUser) {
        userService.registerUser(createUser);
        return "register_success";
    }
}
