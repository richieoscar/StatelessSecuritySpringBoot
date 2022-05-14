package com.example.jwt.controller;

import com.example.jwt.dto.AuthRepsonse;
import com.example.jwt.dto.AuthRequest;
import com.example.jwt.dto.RegisterRequeste;
import com.example.jwt.service.AuthService;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthRepsonse> loginUser(@RequestBody AuthRequest authRequest){
        AuthRepsonse authRepsonse = authService.authenticateUser(authRequest);
        return ResponseEntity.ok(authRepsonse);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequeste registerRequeste){
        String response = userService.register(registerRequeste);
        return ResponseEntity.ok(response);
    }

}
