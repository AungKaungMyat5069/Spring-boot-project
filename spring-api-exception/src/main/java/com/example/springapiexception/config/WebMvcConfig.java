package com.example.springapiexception.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    // Important ** (message converter is not to allow message is necessary)
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // AbstractJackson2HttpMessageConverter is converter that changes java language to json and json to java
        Optional<HttpMessageConverter<?>> foundConverter = converters.stream()
                .filter(c -> c instanceof AbstractJackson2HttpMessageConverter)
                .findFirst();
        if (foundConverter.isPresent()) {
            AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) foundConverter.get();
            // unknown properties(like firstName is name) is to fail
            converter.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        }
    }
}
