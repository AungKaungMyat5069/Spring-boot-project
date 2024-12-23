package org.example.authrizedemo.config;

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
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails john = User.withUsername("john").password("12345").authorities("write","read").build();
//        UserDetails mary = User.withUsername("mary").password("12345").authorities("read").build();

//        UserDetails john = User.withUsername("john").password("12345").authorities("ROLE_WRITE","ROLE_READ").build();

        // this variable is same as above role has "ROLE_" in front of arguments
        UserDetails mary = User.withUsername("mary").password("12345").authorities("READ").build();
        UserDetails john = User.withUsername("john").password("12345").roles("WRITE","READ").build();
        UserDetails uu = User.withUsername("uu").password("12345").roles("READ", "DELETE").build();
        return new InMemoryUserDetailsManager(john, mary);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // hasAnyAuthority is many like an argument list but // hasAuthority has only argument
        http.httpBasic(Customizer.withDefaults());


        // Authority
//        http.authorizeHttpRequests(
//                c -> c
//                        .requestMatchers("/home").permitAll()
//                        .requestMatchers("/task").hasAuthority("write") // this is rule
//                        .requestMatchers("/hello").hasAnyAuthority("write","read") // this is rule
//                        .anyRequest().authenticated()
//        );

        // Role
//        http.authorizeHttpRequests(
//                c -> c
//                        .requestMatchers("/home").permitAll()
//                        .requestMatchers("/task").hasRole("WRITE") // this is rule
//                        .requestMatchers("/hello").hasAnyRole("WRITE","READ") // this is rule
//                        .anyRequest().authenticated()
//        );

//      webExpressionAuthorizationManager is used for except option
//        like this
        String expression = """
                hasRole('READ') and
                !hasRole('DELETE')
                """;
        http.authorizeHttpRequests(
                c -> c.anyRequest()
                        .access(new WebExpressionAuthorizationManager(expression))
        );
        return http.build();
    }
}
