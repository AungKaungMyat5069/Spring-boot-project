package org.example.securitycontextdemo.config;

import org.example.securitycontextdemo.security.CustomEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails john = User.withUsername("john")
                .password("12345").authorities("write").build();
        UserDetails mary = User.withUsername("mary")
                .password("123456").authorities("read").build();

        return new InMemoryUserDetailsManager(john, mary);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.httpBasic(Customizer.withDefaults());
        // custom Entry Point
        http.httpBasic(c -> {
           c.realmName("other");
           c.authenticationEntryPoint(new CustomEntryPoint());
        });
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }
}
