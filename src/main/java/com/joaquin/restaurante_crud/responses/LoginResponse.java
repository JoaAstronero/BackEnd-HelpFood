package com.joaquin.restaurante_crud.responses;


import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private long expiresIn;
}
