package org.example.defaultspringsecurity.config;

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
    //Authentication Provider have UserDetailService and PasswordEncoder

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails john = User.withUsername("john")
                .password("12345")
                .authorities("write")
                .build();
        UserDetails mary = User.withUsername("mary")
                .password("12345")
                .authorities("read")
                .build();
        var uds = new InMemoryUserDetailsManager();
        uds.createUser(john);
        uds.createUser(mary);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //this method is which one is allowed and which not
    // if you want to be all are Authentication, you don't need this method
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //two type httpBasic and httpForm ,
        // httpBasic is working with no cache
        //httpForm is working with session, so it will be hard to test security
        http.httpBasic(Customizer.withDefaults());

//        that will allow all url . that is no security
//        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());

//        that will authenticate all url. every url need username and password
//        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

//        that will allow /home url but other url need authentication
        http.authorizeHttpRequests(c -> c.requestMatchers("/home").permitAll()
                .anyRequest().authenticated());

        // that will allow only one person that name doe other are not
//        UserDetails doe = User.withUsername("doe").password("12345")
//                .authorities("wirte").build();
//        var userDetailsService = new InMemoryUserDetailsManager();
//        userDetailsService.createUser(doe);
//        http.userDetailsService(userDetailsService);
        return http.build();
    }
}
