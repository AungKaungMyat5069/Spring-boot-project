package org.example.loginformdemo.config;


import org.example.loginformdemo.handler.CustomAuthenticationFailure;
import org.example.loginformdemo.handler.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationFailure failure) {
        this.successHandler = successHandler;
        this.failure = failure;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var john  = User.withUsername("john").password("12345").authorities("write").build();
        var mary = User.withUsername("mary").password("12345").authorities("read").build();
        return new InMemoryUserDetailsManager(john, mary);
    }

    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailure failure;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.formLogin(c ->{
//            c.defaultSuccessUrl("/hello", true);
//            c.successHandler(successHandler);
//            c.failureHandler(failure);
//        });
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }
}
