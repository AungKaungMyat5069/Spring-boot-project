package org.example.securitymaster.config;

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
    public UserDetailsService userDetailsService() {
        UserDetails john = User.withUsername("john").password("john").roles("SUPER_ADMIN").build();
        UserDetails emma = User.withUsername("emma").password("emma").roles("EMPLOYEES_ADMIN").build();
        UserDetails william = User.withUsername("william").password("william").roles("DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ", "DEPARTMENTS_CREATE").build();
        UserDetails lucas = User.withUsername("lucas").password("lucas").roles("CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ").build();
        UserDetails tom = User.withUsername("tom").password("tom").roles().build();
        return  new InMemoryUserDetailsManager(john, emma, william, lucas, tom);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(c -> c.loginPage("/login").permitAll());
        http.logout(c -> c.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll());
        http.authorizeHttpRequests(c ->
                c.requestMatchers("/", "/bootstrap/**").permitAll()
                        .requestMatchers("/employee-form", "/employee-delete",
                                "/employee-save", "/list-employee").hasAnyRole("SUPER_ADMIN", "EMPLOYEES_ADMIN")
                        .requestMatchers("/list-customer").hasAnyRole("SUPER_ADMIN", "CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ")
                        .requestMatchers("/save-department", "/create-department", "/list-department").hasAnyRole("SUPER_ADMIN","DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ", "DEPARTMENTS_CREATE")
                        .requestMatchers("/customer-form", "/save-customer", "/delete-customer","/delete-department").hasAnyRole("SUPER_ADMIN")
                .anyRequest().authenticated());
//        http.csrf(c -> c.disable());
        return http.build();
    }
}
