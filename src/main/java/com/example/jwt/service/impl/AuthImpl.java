package com.example.jwt.service.impl;

import com.example.jwt.dto.AuthRepsonse;
import com.example.jwt.dto.AuthRequest;
import com.example.jwt.service.AuthService;
import com.example.jwt.eception.InvalidCredentialsException;
import com.example.jwt.utility.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

@Slf4j
@Service
public class AuthImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    private Authentication isAuthenticated;
    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public AuthRepsonse authenticateUser(AuthRequest request) {
        log.info("Authenticate User with Credentials {}", request);
        String jwtToken = null;
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
        try {
            log.info("Authenticating User");
            authenticationManager.authenticate(userToken);
            log.info("Authentication Successful");

        } catch (Exception e) {
            log.error("Error Occured while authenticating {}", e.getMessage());
            throw new InvalidCredentialsException("Invalid Credentials");
        }

        log.info("Generating Token");
        jwtToken = jwtUtils.generateToken(request.getUserName());
        log.info("Token Generated");
        AuthRepsonse authRepsonse = new AuthRepsonse();
        authRepsonse.setStatus("Success");
        authRepsonse.setMessage("Login Successful");
        authRepsonse.setAccessToken(jwtToken);
        return authRepsonse;
    }
}
