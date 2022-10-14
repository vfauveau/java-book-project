package com.example.book.controller;

import com.example.book.repository.entity.user.CreateUser;
import com.example.book.repository.entity.user.User;
import com.example.book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginUser(){
        return "userLogin";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("createUser", new CreateUser());
        return "userRegister";

    }

    @PostMapping("/register")
    public String createUser(@Valid CreateUser createUser, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("createUser" , createUser);
            return "userRegister";
        }else{
            userService.registerUser(createUser);
            return "userLogin";
        }
    }

    /*
    le post est fait par spring security
     */
}
