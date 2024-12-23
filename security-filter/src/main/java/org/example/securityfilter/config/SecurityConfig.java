package org.example.securityfilter.config;

import org.example.securityfilter.filtercustom.CustomFilter;
import org.example.securityfilter.filtercustom.LoggerFilterSpring;
import org.example.securityfilter.filtercustom.StaticKeyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

public class SecurityConfig {

    @Autowired
    private StaticKeyFilter staticKeyFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class).addFilterAfter(new LoggerFilterSpring(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(staticKeyFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(c-> c.anyRequest().permitAll());
        return http.build();
    }
}
