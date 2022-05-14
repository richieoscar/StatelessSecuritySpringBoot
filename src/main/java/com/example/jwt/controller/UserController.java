package com.example.jwt.controller;

import com.example.jwt.dto.RegisterRequeste;
import com.example.jwt.model.AppUser;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<RegisterRequeste> getUser(@RequestParam("name") String name) {
        Optional<AppUser> byUsername = userRepository.findByUsername(name);
        if (byUsername.isPresent()) {
            RegisterRequeste user = new RegisterRequeste();
            user.setUsername(byUsername.get().getUsername());
            user.setPhoneNumber(byUsername.get().getPhoneNumber());
            return ResponseEntity.ok(user);
        } else return null;
    }
}
