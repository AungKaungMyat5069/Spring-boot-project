package org.example.methodsecuritydemo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NameService {

    @PreAuthorize("hasRole('ADMIN')")
    public String getName() {
        return "Denny's Boy";
    }


    private Map<String , List<String >> secretName =
            Map.of(
                    "john" , List.of("John", "Doe") ,
                    "mary" , List.of("Mary", "serley")
            );

    // this is used for the name argument like aop
    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretName(String name) {
        return secretName.get(name);
    }
}
