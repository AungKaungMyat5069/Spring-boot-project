package com.example.todobackend.config;

import com.example.todobackend.jwt.JwtAuthenticationEntryPoint;
import com.example.todobackend.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }

    /* @Bean
     public UserDetailsService userDetailsService() {
         var mary = User.withUsername("mary").password("12345").authorities("read").build();
         var john = User.withUsername("john").password("1234").authorities("admin").build();
         return new InMemoryUserDetailsManager(mary, john);
     }*/
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
//        this authenticationManager and passwordEncoder() used with bean then security will work like magic
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
//        http.authenticationProvider(daoAuthenticationProvider());
        http.authorizeHttpRequests(c -> {

//            c.requestMatchers(HttpMethod.POST, "/api/**").hasAuthority("admin");
//            c.requestMatchers(HttpMethod.PUT, "/api/**").hasAuthority("admin");
//            c.requestMatchers(HttpMethod.PATCH, "/api/**").hasAuthority("admin");
//            c.requestMatchers(HttpMethod.DELETE, "/api/**").hasAuthority("admin");
            c.requestMatchers("/api/auth/**").permitAll();
            c.anyRequest().authenticated();
        });

        http.cors(
                c -> {
                    CorsConfigurationSource source = request -> {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(List.of("http://localhost:5173", "http://localhost:4200")); // more safe then that CrossOrigin
                        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                        configuration.setAllowedHeaders(List.of("*"));
                        configuration.setAllowCredentials(true);
                        //Note : when you use this don't forget to check it is singular or plural in method call
                        return  configuration;
                    };
                c.configurationSource(source);
                }

        );
        http.csrf(AbstractHttpConfigurer::disable);
        http.exceptionHandling(
                exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint)
        );
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
