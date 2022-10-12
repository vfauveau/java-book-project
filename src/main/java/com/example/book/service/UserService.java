package com.example.book.service;

import com.example.book.repository.entity.user.CreateUser;
import com.example.book.repository.entity.user.User;
import com.example.book.repository.entity.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(CreateUser createUser) {
        User user = new User();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(createUser.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(createUser.getEmail());
        userRepository.save(user);
    }

}
