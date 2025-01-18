package com.example.springapiexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


// custom exception
// ResponseStatusException change the Response error
// note : spring can only exception only 500 server error, so ...
public class NamedAdminException extends ResponseStatusException {
    public NamedAdminException() {
        super(HttpStatus.BAD_REQUEST, "First Name cannot be admin");
    }
}
