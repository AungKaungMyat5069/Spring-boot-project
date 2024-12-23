package org.example.securityfilter.filtercustom;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


//this is spring do filter
public class LoggerFilterSpring extends OncePerRequestFilter {

    // this is just to see that method is work or not
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestId = request.getHeader("Request-ID");
        logger.info("successfully Request ID: {}", requestId);

//        *** Don't forget that, but you will forget that when you finish
        filterChain.doFilter(request, response);
    }
}
