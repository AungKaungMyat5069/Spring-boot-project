package org.example.methodsecuritydemo.config;

import org.example.methodsecuritydemo.evaluator.DocumentPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
//        (securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
// prePostEnabled =true is default and other default is false
public class SecurityConfig {

    private final DocumentPermissionEvaluator permissionEvaluator;

    public SecurityConfig(DocumentPermissionEvaluator permissionEvaluator) {
        this.permissionEvaluator = permissionEvaluator;
    }


    @Bean
    public MethodSecurityExpressionHandler expressionHandler(){
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        return expressionHandler;
    }



    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails john = User.withUsername("john").password("john").roles("USER").build();
        UserDetails mary = User.withUsername("mary").password("mary").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(john, mary);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }
}
