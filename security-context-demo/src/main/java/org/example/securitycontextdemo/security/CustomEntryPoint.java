package org.example.securitycontextdemo.security;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomEntryPoint implements AuthenticationEntryPoint {

    //this method will show in Header message
    // curl -v http://...
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("Hi", "I am Custom EntryPoint");
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }
}
