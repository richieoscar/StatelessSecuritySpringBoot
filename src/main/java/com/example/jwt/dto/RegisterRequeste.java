package com.example.jwt.dto;

import lombok.Data;

@Data
public class RegisterRequeste {

    private String username;
    private String password;
    private String phoneNumber;
}
