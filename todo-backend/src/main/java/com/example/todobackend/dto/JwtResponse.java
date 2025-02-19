package com.example.todobackend.dto;

public class JwtResponse {

    private String tokenAccess;
    private final String type = "Bearer";

    public JwtResponse() {

    }

    public String getTokenAccess() {
        return tokenAccess;
    }

    public void setTokenAccess(String tokenAccess) {
        this.tokenAccess = tokenAccess;
    }

    public String getType() {
        return type;
    }
}
