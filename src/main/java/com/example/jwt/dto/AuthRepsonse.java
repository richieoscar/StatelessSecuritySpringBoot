package com.example.jwt.dto;

import lombok.Data;

@Data
public class AuthRepsonse {
    private String status;
    private String message;
    private String accessToken;
}
