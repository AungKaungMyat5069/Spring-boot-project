package com.example.todobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReadyEmailException extends ResponseStatusException {

    public ReadyEmailException() {
        super(HttpStatus.BAD_REQUEST, "Email is already used");
    }
}
