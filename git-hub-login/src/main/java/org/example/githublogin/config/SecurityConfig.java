package org.example.githublogin.config;

import ch.qos.logback.core.net.server.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("Ov23liYTkyfrtt0uMKZ0")
                .clientSecret("Ov23liYTkyfrtt0uMKZ0")
                .build();
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2Login(c -> c.clientRegistrationRepository(clientRegistrationRepository()));
        http.authorizeHttpRequests( c -> c.anyRequest().authenticated());
        return http.build();
    }
}
