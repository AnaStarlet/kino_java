package com.kino.kinobackend.controller;

import com.kino.kinobackend.model.User;
import com.kino.kinobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Ошибка: пользователь с таким email уже существует";
        }
        userRepository.save(user);
        return "Успешная регистрация!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return "Успешный вход! (В будущем здесь будет JWT-токен)";
        }
        return "Ошибка: неверный email или пароль";
    }
}