package com.haythmKenway.shellcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")  // Adjust the mapping pattern as needed
                .allowedOrigins("http://localhost:3000")  // Adjust the allowed origin URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Adjust the allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (e.g., cookies)
    }
}
