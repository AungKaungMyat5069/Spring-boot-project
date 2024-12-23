package org.example.restapidemo.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
// just to show beautiful word in gitHub
public class CustomWebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> foundConverter = converters.stream()
                .filter(m -> m instanceof AbstractJackson2HttpMessageConverter).findFirst();
        if (foundConverter.isPresent()) {

            AbstractJackson2HttpMessageConverter converter =
                    (AbstractJackson2HttpMessageConverter) foundConverter.get();
            converter.getObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

        }
    }
}
