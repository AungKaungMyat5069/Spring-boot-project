package com.example.todobackend.controller;

import com.example.todobackend.dto.JwtResponse;
import com.example.todobackend.dto.LoginDto;
import com.example.todobackend.dto.RegisterPerson;
import com.example.todobackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final  AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String > register(@RequestBody RegisterPerson user) {
        return new ResponseEntity<>(authService.register(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDto user) {
        String token = authService.loginService(user);
        JwtResponse response = new JwtResponse();
        response.setTokenAccess(token);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
