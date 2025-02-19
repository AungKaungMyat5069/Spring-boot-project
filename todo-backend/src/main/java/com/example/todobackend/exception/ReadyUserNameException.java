package com.example.todobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReadyUserNameException extends ResponseStatusException {

    public ReadyUserNameException() {
        super(HttpStatus.BAD_REQUEST, "Username is ready used");
    }
}
