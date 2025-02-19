package com.example.todobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class IdNotFoundException extends ResponseStatusException {

    public IdNotFoundException(long id) {
        // super need to call when class extends ResponseStatusException
        super(HttpStatus.NOT_FOUND, String.format("Id %s not found", id));
    }
}
