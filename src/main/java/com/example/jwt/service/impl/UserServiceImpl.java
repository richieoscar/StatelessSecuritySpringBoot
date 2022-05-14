package com.example.jwt.service.impl;

import com.example.jwt.dto.RegisterRequeste;
import com.example.jwt.model.AppUser;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequeste registerRequeste) {
        if (registerRequeste != null) {
            AppUser user = AppUser.builder()
                    .password(passwordEncoder.encode(registerRequeste.getPassword()))
                    .phoneNumber(registerRequeste.getPhoneNumber())
                    .username(registerRequeste.getUsername())
                    .build();
            repository.save(user);
            return "Registration Successful";
        }
        return "Registration Not Sucessful";
    }
}
