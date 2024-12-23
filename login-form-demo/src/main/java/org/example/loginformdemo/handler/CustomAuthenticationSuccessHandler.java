package org.example.loginformdemo.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


// this is example User Or Admin Page
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var auth = authentication.getAuthorities();
        var authorities = auth.stream().filter(a -> a.getAuthority().equals("write")).findFirst();

        if (authorities.isPresent()) {
            response.sendRedirect("/hello");
        } else {
            response.sendRedirect("/error");
        }
    }
}
