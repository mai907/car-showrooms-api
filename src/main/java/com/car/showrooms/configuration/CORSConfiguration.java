package com.car.showrooms.configuration;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CORSConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("POST", "PATCH", "GET", "DELETE")
                .allowCredentials(true);


    }
}

