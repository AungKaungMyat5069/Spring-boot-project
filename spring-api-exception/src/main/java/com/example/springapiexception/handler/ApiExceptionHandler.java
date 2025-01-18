package com.example.springapiexception.handler;

import com.example.springapiexception.exception.ApiError;
import com.example.springapiexception.exception.NamedAdminException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
//extends Advice -> @BeforeAdvice and @AfterAdvice etc
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    // Just read method name, You will get it
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // delete the super code
        return handleExceptionInternal(ex, message(status.value(), ex), headers, status, request);
    }

    private ApiError message(int statusCode, Exception e) {
        String message = e == null ? "Unknown Error" : e.getClass().getSimpleName();
        String developerMessage = ExceptionUtils.getRootCauseMessage(e);
        return new ApiError(statusCode, message, developerMessage);// go back to above method
    }

    // start 2
    // just rerun the error with variable wrong like email is gmail

    // start 3

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(ex, message(status.value(), ex), headers, status, request);
    }

    //start4 // Custom
    @ExceptionHandler(value = {
            ConstraintViolationException.class, //not wrong import test
            DataIntegrityViolationException.class,

    // Database must be correct, and can be manipulation is DataIntegrityViolationException
            //start 5
            NamedAdminException.class
        }
    )
    public ResponseEntity<Object> handleExceptional(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST.value(), ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
