package com.example.jwt.service;

import com.example.jwt.dto.RegisterRequeste;

public interface UserService {

    String register(RegisterRequeste registerRequeste);
}
