package com.example.jwt.service;

import com.example.jwt.dto.AuthRepsonse;
import com.example.jwt.dto.AuthRequest;
import com.example.jwt.utility.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

public interface AuthService {

    AuthRepsonse authenticateUser(AuthRequest request);
}
